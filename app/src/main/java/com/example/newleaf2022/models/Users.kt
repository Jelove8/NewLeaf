package com.example.newleaf2022.models

import kotlin.collections.ArrayList

data class Users(val name: String,
                 val password: String? = null) {

    private lateinit var budgets: ArrayList<Budgets>
    private lateinit var currentBudget: Budgets

    fun getBudget(index: Int): Budgets {
        return budgets[index]
    }
    fun getCurrentBudget(): Budgets {
        return currentBudget
    }

    fun setBudgets(newBudgets: ArrayList<Budgets>) {
        budgets = newBudgets
    }
    fun setCurrentBudget(newBudget: Budgets) {
        currentBudget = newBudget
    }

}
