package com.example.newleaf2022.models

import com.google.firebase.database.FirebaseDatabase

class Model {
    private val database = FirebaseDatabase.getInstance()

    private lateinit var currentUser : Users

    fun initializeUser() {
        val guestUser = Users("Guest User")
        guestUser.setBudgets(arrayListOf(Budgets("Guest Budget")))
        currentUser = guestUser
    }


    fun updateCurrentBudget(newBudget: Budgets) {
        currentUser.setNewCurrentBudget(newBudget, "update")
    }

}