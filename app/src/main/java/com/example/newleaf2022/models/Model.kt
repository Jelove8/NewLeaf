package com.example.newleaf2022.models

import android.util.Log
import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.dataclasses.Budgets
import com.example.newleaf2022.dataclasses.Categories
import com.example.newleaf2022.dataclasses.Users
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class Model {
    private val database = FirebaseDatabase.getInstance()

    private lateinit var currentUser : Users

    fun initializeUser() {

        val mockDB = MockDatabase()
        val mockUser = mockDB.getMockUser()

        if (mockUser == null) {
            val guestUser = Users("Guest User")
            guestUser.setBudgets(arrayListOf())
            currentUser = guestUser
        }
        else {
            currentUser = mockUser
        }
    }

    // The "current budget" is always User.budgets[0]
    fun getCurrentBudget(): Budgets {
        return currentUser.getBudget(0)
    }

    fun updateCurrentBudget(newBudget: Budgets) {
        currentUser.setNewCurrentBudget(newBudget, "update")
    }

}