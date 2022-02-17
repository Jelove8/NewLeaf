package com.example.newleaf2022.models

import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.dataclasses.Budgets
import com.example.newleaf2022.dataclasses.Categories

class Model {

    private lateinit var currentBudget: Budgets



    fun initializeModel() {
        val database = MockDatabase()
        database.initializeMockDatabase()
        currentBudget = database.getMockBudget()

        if (currentBudget.name.isEmpty()) {
            currentBudget = Budgets("New Budget", "02162022")
        }
    }
    fun getCurrentBudget(): Budgets? {
        return if (currentBudget.name.isEmpty()) {
            null
        } else {
            currentBudget
        }

    }

    fun addAccount(new: Accounts) {
       if (currentBudget.accounts.isNullOrEmpty()) {
           currentBudget.accounts = arrayListOf()
       }
        currentBudget.accounts.add(new)
    }

    fun changeCategories(new: ArrayList<Categories>) {
        currentBudget.categories = new
    }

    fun getData(): ArrayList<Any> {

        // Calculating the current Account Balance
        var currentAccountsBalance = 0.00
        for (i in 0 until currentBudget.accounts.size) {
            currentAccountsBalance += currentBudget.accounts[i].balance
        }

        // Calculating a list of


        return arrayListOf(currentAccountsBalance)
    }
}