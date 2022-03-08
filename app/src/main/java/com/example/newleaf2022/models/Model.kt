package com.example.newleaf2022.models

import android.util.Log
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.dataclasses.FiscalYear
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



}