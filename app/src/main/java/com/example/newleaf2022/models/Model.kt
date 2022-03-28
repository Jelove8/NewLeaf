package com.example.newleaf2022.models

import android.annotation.SuppressLint
import android.util.Log
import com.example.newleaf2022.adapters.CategoryAdapter
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.dataclasses.Users
import com.example.newleaf2022.viewmodels.BudgetsViewModel
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

    fun updateSubcategoryAssignedValue(newSubAssigned: Double, targetCategory: Categories, targetSubcategory: Categories, targetMonth: Int, targetYear: Int, budgetsVM: BudgetsViewModel) {
        // Updating values of the current month
        var oldUnassigned = getCurrentBudget().getUnassigned()
        var oldSubAssigned = 0.00
        var oldSubAvailable = 0.00
        var oldTotalAssigned = 0.00
        var oldTotalAvailable = 0.00

        var newSubAvailable = 0.00
        var newTotalAssigned = 0.00
        var newTotalAvailable = 0.00
        var newUnassigned = 0.00
        val newValues = mutableListOf<Double>()

        for (yearlyBudget in getCurrentBudget().getYearlyBudgets()) {
            if (yearlyBudget.getYear() == targetYear) {
                for (category in yearlyBudget.getMonthlyBudgets()[targetMonth]) {
                    if (category == targetCategory) {
                        oldTotalAssigned = category.getAssigned()
                        oldTotalAvailable = category.getAvailable()
                        for (subcategory in category.getSubcategories()) {
                            if (subcategory == targetSubcategory) {
                                oldSubAssigned = subcategory.getAssigned()
                                oldSubAvailable = subcategory.getAvailable()

                                newSubAvailable = oldSubAvailable - oldSubAssigned + newSubAssigned
                                newTotalAssigned = oldTotalAssigned - oldSubAssigned + newSubAssigned
                                newTotalAvailable = oldTotalAvailable - oldTotalAssigned + newTotalAssigned
                                newUnassigned = oldUnassigned + oldTotalAssigned - newTotalAssigned

                                newValues.add(newUnassigned)
                                newValues.add(newSubAssigned)
                                newValues.add(newSubAvailable)
                                newValues.add(newTotalAssigned)
                                newValues.add(newTotalAvailable)

                                subcategory.setAssigned(newSubAssigned)
                                subcategory.setAvailable(newSubAvailable)
                                category.setAssigned(newTotalAssigned)
                                category.setAvailable(newTotalAvailable)
                                getCurrentBudget().setUnassigned(newUnassigned)

                            }
                        }
                    }
                }
            }
        }
        budgetsVM.updateCategoryRecyclerView(newValues)
    }



}