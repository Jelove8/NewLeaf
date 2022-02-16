package com.example.newleaf2022.models

import com.example.newleaf2022.viewmodels.*

class Model {

    private lateinit var currentBudget: Budgets
    private lateinit var currentAccounts: ArrayList<Accounts>
    private lateinit var currentCategories: ArrayList<Categories>

    fun initializeModel() {
        val database = MockDatabase()
        database.initializeMockDatabase()
        currentBudget = database.getMockBudget()
        currentAccounts = currentBudget.accounts
        currentCategories = currentBudget.categories
    }

    fun getCurrentBudget(): Budgets {
        return currentBudget
    }

    fun getCurrentCategories(): ArrayList<Categories> {
        return currentCategories
    }

    fun getCurrentAccounts(): ArrayList<Accounts> {
        return currentAccounts
    }

}