package com.example.newleaf2022.viewmodels

import androidx.lifecycle.ViewModel
import com.example.newleaf2022.models.dataclasses.Accounts
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.Model

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


    // Used in BudgetsFragment
    fun getAllCategories(): ArrayList<Categories> {
        val allCategories = arrayListOf<Categories>()
        for (category in getCurrentMonthlyBudget()) {
            allCategories.add(category)
            for (subcategory in category.getSubcategories()) {
                allCategories.add(subcategory)
            }
        }
        return allCategories
    }
    fun getCategoryPositions(): ArrayList<Int> {
        val categoryPositions = arrayListOf<Int>()
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



    fun editSubassigned(newAssigned: Double = 0.00, editSubcategory: Categories): ArrayList<ArrayList<Double>> {

        val oldUnassigned = getCurrentBudget().getUnassigned()
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
        val oldValues = arrayListOf(oldUnassigned, oldAvailable, oldTotalAssigned, oldTotalAvailable)

        // Creating the list of string that will be used to update the appropriate views and the Model
        val newValues = arrayListOf<Double>()   // 0 = unassigned, 1 = subAvailable, 2 = totalAssigned, 3 = totalAvailable
        newValues.add(oldUnassigned + oldAssigned - newAssigned)
        newValues.add(oldAvailable - oldAssigned + newAssigned)
        newValues.add(newAssigned)
        newValues.add(oldTotalAvailable - oldAssigned + newAssigned)


        return arrayListOf(oldValues, newValues)
    }

    fun updateSubcategoryAssignedValue(oldValues: ArrayList<Double>, newValues: ArrayList<Double>, targetCategoryIndex: Int, targetSubcategoryIndex: Int) {

        // Tracking which category will be affected
        lateinit var targetCategory: Categories
        lateinit var targetSubcategory: Categories

        var categoryCount = 0
        for ((c, category) in getCurrentMonthlyBudget().withIndex()) {
            if (categoryCount == targetCategoryIndex) {
                targetCategory = getCurrentBudget().getMainCategories()[c]
            }
            categoryCount++

            for ((s, _) in category.getSubcategories().withIndex()) {
                if (categoryCount == targetSubcategoryIndex) {
                    targetSubcategory = getCurrentBudget().getMainCategories()[s]
                }
                categoryCount++
            }
        }
        model.updateSubcategoryAssignedValue(oldValues, newValues, targetCategory, targetSubcategory, currentMonthDisplay, currentFiscalYear)
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
        getCurrentBudget().setUnassigned(getCurrentBudget().getUnassigned() + getCurrentBudget().getMainCategories()[position].getAssigned() - newCategory.getAssigned())
        getCurrentBudget().editCategories(newCategory, getCurrentBudget().getMainCategories()[position])
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

    fun getUnassignedValue(): Double {
        return getCurrentBudget().getUnassigned()
    }


}