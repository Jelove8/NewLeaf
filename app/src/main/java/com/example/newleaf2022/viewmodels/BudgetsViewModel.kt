package com.example.newleaf2022.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newleaf2022.adapters.CategoryAdapter
import com.example.newleaf2022.models.dataclasses.Accounts
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.Model
import java.util.*
import kotlin.collections.ArrayList

class BudgetsViewModel : ViewModel() {

    private lateinit var model: Model
    private var currentFiscalYear: Int = 0
    private  var currentMonthDisplay: Int = 0   // Need to find a way to init { get current month }
    // 0 = Jan, 1 = Feb, ... 11 = Dec

    // General Functions
    fun getCurrentMonthlyBudget(): MutableList<Categories> {
        var monthlyBudget = mutableListOf<Categories>()
        // Looping through all items within yearlyBudgets, until the corresponding FiscalYear object is found
        for (item in model.getCurrentBudget().getYearlyBudgets()) {
            if (item.getYear() == currentFiscalYear) {
                // Depending on the current month, a specific arraylist of categories will be returned
                monthlyBudget = item.getMonthlyBudgets()[currentMonthDisplay]
            }
        }
        return monthlyBudget
    }

    fun getCurrentYear(): Int {
        return currentFiscalYear
    }

    // Used in MainActivity
    fun setCurrentDate(method: String, input: MutableList<Int>? = null) {
        when (method) {
            "current" -> {
                val currentCalendar = Calendar.getInstance()
                currentFiscalYear = currentCalendar.get(Calendar.YEAR)
                currentMonthDisplay = currentCalendar.get(Calendar.MONTH)
                Log.d("currentDate","Month: $currentMonthDisplay")
                Log.d("currentDate","Year: $currentFiscalYear")
            }
            "custom" -> {
                when (input!!.size) {
                    1 -> {
                        currentMonthDisplay = input[0]
                    }
                    2 -> {
                        currentMonthDisplay = input[0]
                        currentFiscalYear = input[1]
                    }
                }
            }
        }

    }


    // Display Monthly Budget
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var selectedSubcategoryViewHolder: CategoryAdapter.BudgetsViewHolder
    fun selectCategoryViewHolder(adapter: CategoryAdapter,categoryViewHolder: CategoryAdapter.BudgetsViewHolder) {
        categoryAdapter = adapter
        selectedSubcategoryViewHolder = categoryViewHolder
    }
    fun updateSubcategoryAssignedValue (newSubAssigned: Double) {
        model.updateSubcategoryAssignedValue(newSubAssigned,selectedSubcategoryViewHolder.selectedCategory,selectedSubcategoryViewHolder.selectedSubcategory,currentMonthDisplay,currentFiscalYear, this)
    }
    fun updateCategoryRecyclerView(newValues: MutableList<Double>) {
        selectedSubcategoryViewHolder.updateViewHolder(categoryAdapter)
        categoryAdapter.updateUnassignedTV(newValues[0])
    }
    fun getSelectedSubcategoryViewholder(): CategoryAdapter.BudgetsViewHolder {
        return selectedSubcategoryViewHolder
    }




    // Returns the current month's list of categories and subcategories (passed through a recycler view)
    fun getAllCategories(): MutableList<Categories> {
        val allCategories = mutableListOf<Categories>()
        for (category in getCurrentMonthlyBudget()) {
            allCategories.add(category)
            for (subcategory in category.getSubcategories()) {
                allCategories.add(subcategory)
            }
        }
        return allCategories
    }
    fun getCategoryPositions(): MutableList<Int> {
        val categoryPositions = mutableListOf<Int>()
        var categoryCount = 0
        for (category in getCurrentMonthlyBudget()) {
            categoryPositions.add(categoryCount)
            categoryCount++
            for (subcategory in category.getSubcategories()) {
                categoryCount++
            }
        }
        return categoryPositions
    }






    fun updateModelBudget(model: Model) {
        model.updateCurrentBudget(getCurrentBudget())
    }


    fun initializeUser(currentModel: Model) {
        model = currentModel
        model.initializeUser(1)
        currentFiscalYear = 2022
        currentMonthDisplay = 2
    }



    fun getCurrentBudget(): Budgets {
        return model.getCurrentBudget()
    }

    fun addAccount(newAccount: Accounts, model: Model) {
        getCurrentBudget().getAccounts().add(newAccount)
        getCurrentBudget().setUnassigned(getCurrentBudget().getUnassigned() + newAccount.getBalance())
        model.updateCurrentBudget(getCurrentBudget())
    }


}