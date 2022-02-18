package com.example.newleaf2022.viewmodels

import androidx.lifecycle.ViewModel
import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.dataclasses.Budgets
import com.example.newleaf2022.dataclasses.Categories
import com.example.newleaf2022.models.Model

class BudgetsViewModel : ViewModel() {

    private lateinit var currentBudget: Budgets

    // Initializes currentBudget with data from Database.
    fun initializeBudget(model: Model) {
        model.initializeUser()
        currentBudget = model.getCurrentBudget()
    }

    // Budgets
    fun getCurrentBudget(): Budgets {
        return currentBudget
    }

    fun updateCategories(newCategories: ArrayList<Categories>, model: Model) {
        // Updating unassigned value
        var totalAvailable = 0.00
        for (item in newCategories) {
            totalAvailable += item.totalAvailable
        }

        var totalBalance = 0.00
        for (item in currentBudget.accounts) {
            totalBalance += item.balance
        }

        val newUnassigned = totalBalance - totalAvailable

        currentBudget.categories = newCategories
        currentBudget.unassigned = newUnassigned
        model.updateCurrentBudget(currentBudget)
    }

    fun addAccount(newAccount: Accounts, model: Model) {
        currentBudget.accounts.add(newAccount)
        currentBudget.unassigned += newAccount.balance
        model.updateCurrentBudget(currentBudget)
    }

}