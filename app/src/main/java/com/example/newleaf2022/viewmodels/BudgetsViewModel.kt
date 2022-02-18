package com.example.newleaf2022.viewmodels

import androidx.lifecycle.ViewModel
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

    fun updateCategories(newCategories: ArrayList<Categories>) {
        currentBudget.categories = newCategories
    }

}