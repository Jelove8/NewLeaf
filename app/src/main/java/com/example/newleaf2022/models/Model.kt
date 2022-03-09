package com.example.newleaf2022.models

import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.dataclasses.Users
import com.google.firebase.database.FirebaseDatabase

class Model {
    private val database = FirebaseDatabase.getInstance()

    private lateinit var currentUser : Users

    fun initializeUser(type: Int) {

        when (type) {
            0 -> {
                val guestUser = Users("Guest User")
                guestUser.setBudgets(arrayListOf(Budgets("Guest Budget")))
                guestUser.setCurrentBudget(guestUser.getBudget(0))
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
        return currentUser.getCurrentBudget()
    }


    fun updateCurrentBudget(newBudget: Budgets) {
        currentUser.setCurrentBudget(newBudget)
    }


    // Category Adapter

    fun updateSubcategoryAssignedValue(oldValues: ArrayList<Double>, newValues: ArrayList<Double>, targetCategory: Categories, targetSubcategory: Categories, currentMonthDisplay: Int, currentYear: Int) {
        // Updating the current budget's unassigned value
        getCurrentBudget().setUnassigned(newValues[0])

        // Updating the budget's mainCategories
        for (category in getCurrentBudget().getMainCategories()) {
            if (category == targetCategory) {
                category.setAssigned(newValues[2])
                category.setAvailable(newValues[3])

                // Updating the budget's mainSubcategories
                for (subcategory in category.getSubcategories()) {
                    if (subcategory == targetSubcategory) {
                        subcategory.setAvailable(newValues[1])
                    }
                }
            }
        }

        // Updating the mainCategories of affected monthly budgets
        for (i in currentMonthDisplay + 1 .. 11) {
            // Tracking which yearly budget is affected...
                for (yearlyBudget in getCurrentBudget().getYearlyBudgets()) {
                    if (yearlyBudget.getYear() == currentYear) {
                        // Tracking which monthly budgets are being affected...
                        for (monthlyBudget in yearlyBudget.getMonthlyBudgets()) {
                            if (monthlyBudget.isNotEmpty()) {
                                // Updating the monthly budget's mainCategories
                                for (category in monthlyBudget) {
                                    if (category == targetCategory) {
                                        category.setAssigned(newValues[2])
                                        category.setAvailable(newValues[3])

                                        // Updating the monthly budget's mainSubcategories
                                        for (subcategory in category.getSubcategories()) {
                                            if (subcategory == targetSubcategory) {
                                                subcategory.setAvailable(newValues[1])
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

        }
    }

}