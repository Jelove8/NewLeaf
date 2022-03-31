package com.example.newleaf2022.models.dataclasses

import kotlin.collections.ArrayList

data class Users(private var username: String,
                 private var password: String? = null) {

    private var userBudgets: MutableList<Budgets> = mutableListOf()
    private var lastDisplayedBudgetPosition: Int = 0

    fun getUserBudgets(): MutableList<Budgets> {
        return userBudgets
    }
    fun addUserBudget(newBudget: Budgets) {
        userBudgets.add(newBudget)
    }
    fun deleteUserBudget(positionOfDeletedBudget: Int) {
        userBudgets.removeAt(positionOfDeletedBudget)
    }
    fun getLastDisplayedBudget(): Budgets {
        return userBudgets[lastDisplayedBudgetPosition]
    }
    fun setLastDisplayedBudgetPosition(displayedBudgetPosition: Int) {
        lastDisplayedBudgetPosition = displayedBudgetPosition
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
