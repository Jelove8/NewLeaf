package com.example.newleaf2022.models

import com.example.newleaf2022.viewmodels.*

class Model {

    private lateinit var currentBudget: Budgets



    fun initializeModel() {
        val database = MockDatabase()
        database.initializeMockDatabase()
        currentBudget = database.getMockBudget()
    }
    fun getCurrentBudget(): Budgets {
        return currentBudget
    }

    fun addAccount(new: Accounts) {
       if (currentBudget.accounts.isNullOrEmpty()) {
           currentBudget.accounts = arrayListOf()
       }
        currentBudget.accounts.add(new)
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