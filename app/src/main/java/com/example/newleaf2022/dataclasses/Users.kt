package com.example.newleaf2022.dataclasses

import java.util.*
import kotlin.collections.ArrayList

data class Users(val name: String,
                 val password: String? = null) {

    private lateinit var budgets: ArrayList<Budgets>

    fun getBudget(index: Int): Budgets {
        return budgets[index]
    }
    fun getAllBudgets(): ArrayList<Budgets> {
        return budgets
    }
    fun setBudgets(newBudgets: ArrayList<Budgets>) {
        budgets = newBudgets
    }
    fun setNewCurrentBudget(newBudget: Budgets, replacement: String) {

        when (replacement) {
            "delete" -> {
                budgets[0] = newBudget
            }
            "add" -> {
                val oldBudget = budgets[0]
                budgets[0] = newBudget
                budgets.add(oldBudget)
            }
            else -> {}
        }
    }

}
