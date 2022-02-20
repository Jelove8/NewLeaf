package com.example.newleaf2022.models

import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Users
import com.google.firebase.database.FirebaseDatabase

class Model {
    private val database = FirebaseDatabase.getInstance()

    private lateinit var currentUser : Users

    fun initializeUser(type: Int) {

        when (type) {
            0 -> {
                val guestUser = Users("Guest User")
                guestUser.setBudgets(arrayListOf(Budgets("Guest Budget", 0.00)))
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



    fun updateCurrentBudget(newBudget: Budgets) {
        currentUser.setCurrentBudget(newBudget)
    }

}