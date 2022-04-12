package com.example.newleaf2022.models.dataclasses

import kotlin.collections.ArrayList

data class Users(private var name: String,
                 private var password: String? = null) {


    private lateinit var budgets: ArrayList<Budgets>

    fun getBudget(index: Int): Budgets {
        return budgets[index]
    }
    fun getCurrentBudget(): Budgets {
        return budgets[0]
    }


    fun setBudgets(newBudgets: ArrayList<Budgets>) {
        budgets = newBudgets
    }
    fun setCurrentBudget(newBudget: Budgets) {
        budgets[0] = newBudget
    }

    fun getName(): String {
        return name
    }
    fun setName(newName: String) {
        name = newName
    }

    fun getPassword(newPassword: String) {
        password = newPassword
    }
    fun setPassword(newPassword: String) {
        password = newPassword
    }


}
