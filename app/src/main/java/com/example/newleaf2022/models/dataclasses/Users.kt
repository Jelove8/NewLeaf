package com.example.newleaf2022.models.dataclasses

import kotlin.collections.ArrayList

data class Users(private var username: String,
                 private var password: String? = null) {

    // The user's "Current Budget" will always = userBudgets[0]
    private lateinit var userBudgets: MutableList<Budgets>

    fun getUserBudget(index: Int): Budgets {
        return userBudgets[index]
    }
    fun getUserCurrentBudget(): Budgets {
        return userBudgets[0]
    }


    fun setUserBudget(newBudgets: MutableList<Budgets>) {
        userBudgets = newBudgets
    }
    fun setUserCurrentBudget(newBudget: Budgets) {
        userBudgets[0] = newBudget
    }

    fun getUsername(): String {
        return username
    }
    fun setUsername(newName: String) {
        username = newName
    }

    fun getUserPassword(newPassword: String) {
        password = newPassword
    }
    fun setUserPassword(newPassword: String) {
        password = newPassword
    }


}
