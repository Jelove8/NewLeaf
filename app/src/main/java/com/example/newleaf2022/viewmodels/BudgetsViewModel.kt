package com.example.newleaf2022.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newleaf2022.models.dataclasses.Accounts
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.Model
import com.example.newleaf2022.models.dataclasses.FiscalYear

class BudgetsViewModel : ViewModel() {

    private lateinit var model: Model
    private var currentFiscalYear: Int = 0
    private  var currentMonthDisplay: Int = 0   // Need to find a way to init { get current month }
    // 0 = Jan, 1 = Feb, ... 11 = Dec

    // General Functions
    fun getCurrentMonthlyBudget(): ArrayList<Categories> {
        var monthlyBudget = arrayListOf<Categories>()
        // Looping through all items within yearlyBudgets, until the corresponding FiscalYear object is found
        for (item in model.getCurrentBudget().getYearlyBudgets()) {
            if (item.getYear() == currentFiscalYear) {
                // Depending on the current month, a specific arraylist of categories will be returned
                monthlyBudget = item.getMonthlyBudgets()[currentMonthDisplay]
            }
        }
        return monthlyBudget
    }


    // Used in BudgetsFragment &

    // CategoryAdapter
    fun editSubassigned(oldUnassigned: Double, newAssigned: Double = 0.00, editSubcategory: Categories): ArrayList<String> {

        var oldAssigned = 0.00
        var oldAvailable = 0.00
        var oldTotalAssigned = 0.00
        var oldTotalAvailable = 0.00

        // Getting the old values of the category and subcategory to be affected
        for (category in getCurrentMonthlyBudget()) {
            for (subcategory in category.getSubcategories()) {
                if (subcategory == editSubcategory) {
                    oldAssigned = subcategory.getAssigned()
                    oldAvailable = subcategory.getAvailable()
                    oldTotalAssigned = category.getAssigned()
                    oldTotalAvailable = category.getAvailable()
                }
            }
        }

        // Creating the list of string that will be used to update the appropriate views and the Model
        val outputStrings = arrayListOf<String>()   // 0 = unassigned, 1 = subAvailable, 2 = totalAssigned, 3 = totalAvailable
        outputStrings.add((oldUnassigned + oldAssigned - newAssigned).toString())
        outputStrings.add((oldAvailable - oldAssigned + newAssigned).toString())
        outputStrings.add((oldTotalAssigned - oldAssigned + newAssigned).toString())
        outputStrings.add((oldTotalAvailable - oldAssigned + newAssigned).toString())


        return outputStrings
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

    fun updateCategory(newCategory: Categories, position: Int) {
        // Updating unassigned value
        getCurrentBudget().setUnassigned(getCurrentBudget().getUnassigned() + getCurrentBudget().getCategories()[position].getAssigned() - newCategory.getAssigned())
        getCurrentBudget().editCategories(newCategory, getCurrentBudget().getCategories()[position])
        model.updateCurrentBudget(getCurrentBudget())
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