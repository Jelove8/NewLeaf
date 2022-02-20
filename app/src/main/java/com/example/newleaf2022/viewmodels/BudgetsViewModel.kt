package com.example.newleaf2022.viewmodels

import androidx.lifecycle.ViewModel
import com.example.newleaf2022.models.dataclasses.Accounts
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.dataclasses.Transactions
import com.example.newleaf2022.models.Model

class BudgetsViewModel : ViewModel() {

    private lateinit var currentBudget: Budgets


    fun initializeBudget(model: Model) {
        model.initializeUser(1)
        currentBudget = model.getUser().getCurrentBudget()
    }

    fun updateCategory(newCategory: Categories, position: Int, model: Model) {
        // Updating unassigned value
        currentBudget.unassigned += currentBudget.categories[position].totalAssigned - newCategory.totalAssigned
        currentBudget.categories[position] = newCategory
        model.updateCurrentBudget(currentBudget)
    }


    fun getCurrentBudget(): Budgets {
        return currentBudget
    }

    fun addAccount(newAccount: Accounts, model: Model) {
        currentBudget.accounts.add(newAccount)
        currentBudget.unassigned += newAccount.balance
        model.updateCurrentBudget(currentBudget)
    }

    fun newTransaction(newTransaction: Transactions, model: Model) {

        for (item in currentBudget.transactions) {

        }


    }
}