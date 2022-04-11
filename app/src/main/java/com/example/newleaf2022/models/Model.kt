package com.example.newleaf2022.models

import android.util.Log
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Category
import com.example.newleaf2022.models.dataclasses.MonthlyBudget
import com.example.newleaf2022.models.dataclasses.Users
import com.example.newleaf2022.viewmodels.BudgetsViewModel
import com.google.firebase.database.FirebaseDatabase
import java.time.Month

class Model {
    private val database = FirebaseDatabase.getInstance()

    private lateinit var currentUser : Users


    fun initializeUser(type: Int) {

        when (type) {
            0 -> {
                val guestUser = Users("Guest User")
                guestUser.setUserBudget(mutableListOf(Budgets("Guest Budget")))
                guestUser.setUserCurrentBudget(guestUser.getUserBudgets(0))
                currentUser = guestUser
            }
            1 -> {
                val mockUser = MockDatabase().getMockUser()
                currentUser = mockUser
            }
            else -> {}
        }

    }
    fun getUser(): Users {
        return currentUser
    }

    fun getCurrentBudget(): Budgets {
        return currentUser.userBudgets[currentUser.currentlyDisplayedBudgetIndex]
    }


    // Category Adapter
    fun updateSubcategoryAssignedValue(newSubAssigned: Double, targetCategory: Category, targetSubcategory: Category, targetMonth: Int, targetYear: Int, budgetsVM: BudgetsViewModel) {
        // Updating values of the current month
        var oldUnassigned = getCurrentBudget().bdgtUnassignedMoney
        var oldSubAssigned = 0.00
        var oldSubAvailable = 0.00
        var oldTotalAssigned = 0.00
        var oldTotalAvailable = 0.00

        var newSubAvailable = 0.00
        var newTotalAssigned = 0.00
        var newTotalAvailable = 0.00
        var newUnassigned = 0.00
        var newValues = mutableListOf<Double>()

        // Populating lists of old & new values
        // And then updating the target categories & subcategories (with respect to the current month displayed)
        for (monthlyBdgt in getCurrentBudget().bdgtAllMonthlyBudgets) {
            if (monthlyBdgt.bdgtYear == targetYear && monthlyBdgt.bdgtMonth == targetMonth) {
                for (category in monthlyBdgt.bdgtCategories) {
                    if (category == targetCategory) {
                        oldTotalAssigned = category.catAssignedMoney
                        oldTotalAvailable = category.catAvailableMoney
                        for (subcategory in category.subcategories) {
                            if (subcategory == targetSubcategory) {
                                oldSubAssigned = subcategory.catAssignedMoney
                                oldSubAvailable = subcategory.catAvailableMoney

                                newSubAvailable = oldSubAvailable - oldSubAssigned + newSubAssigned
                                newTotalAssigned = oldTotalAssigned - oldSubAssigned + newSubAssigned
                                newTotalAvailable = oldTotalAvailable - oldTotalAssigned + newTotalAssigned
                                newUnassigned = oldUnassigned + oldTotalAssigned - newTotalAssigned
                                newValues = mutableListOf(
                                    newUnassigned,
                                    newSubAssigned,
                                    newSubAvailable,
                                    newTotalAssigned,
                                    newTotalAvailable
                                )

                                subcategory.catAssignedMoney = newSubAssigned
                                subcategory.catAvailableMoney = newSubAvailable
                                category.catAssignedMoney = newTotalAssigned
                                category.catAvailableMoney = newTotalAvailable
                                getCurrentBudget().bdgtUnassignedMoney = newUnassigned
                            }
                        }
                    }
                }
            }
        }
        budgetsVM.updateCategoryRecyclerView(newValues)

        // Getting a list of monthlyBudgets that need updating.
        val listOfTargetMonthlyBudgets: MutableList<MonthlyBudget> = mutableListOf()
        for (monthlyBdgt in getCurrentBudget().bdgtAllMonthlyBudgets) {
            // Updating monthlyBudgets within the target year
            if (monthlyBdgt.bdgtYear == targetYear && monthlyBdgt.bdgtMonth > targetMonth) {
                listOfTargetMonthlyBudgets.add(monthlyBdgt)
            }
            else if (monthlyBdgt.bdgtYear > targetYear) {
                listOfTargetMonthlyBudgets.add(monthlyBdgt)
            }
        }

        // Updating the list of target monthly budgets
        for (monthlyBdgt in listOfTargetMonthlyBudgets) {
            for (cat in monthlyBdgt.bdgtCategories) {
                if (cat.catName == targetCategory.catName) {
                    // Updating category's monetary values
                    cat.catAvailableMoney += newTotalAvailable - oldTotalAvailable
                    for (subcat in cat.subcategories) {
                        // Updating subcategory's monetary values
                        if (subcat.catName == targetSubcategory.catName) {
                            subcat.catAvailableMoney += newSubAvailable - oldSubAvailable
                        }
                    }
                }
            }
        }



    }
}