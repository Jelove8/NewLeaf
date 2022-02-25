package com.example.newleaf2022.viewmodels

import androidx.lifecycle.ViewModel
import com.example.newleaf2022.models.dataclasses.Accounts
import com.example.newleaf2022.models.dataclasses.Budgets
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.models.dataclasses.Transactions
import com.example.newleaf2022.models.Model

class BudgetsViewModel : ViewModel() {

    private lateinit var currentBudget: Budgets


    fun updateModelBudget(model: Model) {
        model.updateCurrentBudget(currentBudget)
    }


    fun initializeBudget(model: Model) {
        model.initializeUser(1)
        currentBudget = model.getUser().getCurrentBudget()
    }

    fun updateCategory(newCategory: Categories, position: Int, model: Model) {
        // Updating unassigned value
        currentBudget.setUnassigned(currentBudget.getUnassigned() + currentBudget.getCategories()[position].getAssigned() - newCategory.getAssigned())
        currentBudget.editCategories(newCategory, currentBudget.getCategories()[position])
        model.updateCurrentBudget(currentBudget)
    }


    fun getCurrentBudget(): Budgets {
        return currentBudget
    }

    fun addAccount(newAccount: Accounts, model: Model) {
        currentBudget.getAccounts().add(newAccount)
        currentBudget.setUnassigned(currentBudget.getUnassigned() + newAccount.getBalance())
        model.updateCurrentBudget(currentBudget)
    }


}