package com.example.newleaf2022.models

import com.example.newleaf2022.dataclasses.*

class MockDatabase {

    // Mock Budget & Account
    private val databaseBudget = Budgets("Test Budget", "01282022")
    private val databaseAccount = Accounts("Checkings", "Checkings", 3000.00)

    // Mock Transactions
    private val databaseTransaction1 = Transactions(true, 669.21, "Starbucks", databaseAccount, "Unassigned", "01282022", true, "Depositing a paycheck from employer.")
    private val databaseTransaction2 = Transactions(false, 44.17, "Shell", databaseAccount, "Gas", "01292022", true, null)
    private val databaseTransaction3 = Transactions(false, 22.89, "Target", databaseAccount, "Clothes", "01292022", true, "Bought new jeans.")
    private val databaseTransaction4 = Transactions(false, 350.00, "Target", databaseAccount, "Clothes", "01292022", true, "Bought new jeans.")
    private val transactionsList = arrayListOf(databaseTransaction1, databaseTransaction2, databaseTransaction3, databaseTransaction4)

    // Mock Subcategories
    private val databaseSubcategory1 = Subcategories("Rent")
    private val databaseSubcategory2 = Subcategories("Student Loans")
    private val databaseSubcategory3 = Subcategories("Groceries")
    private val databaseSubcategory4 = Subcategories("Gas")
    private val databaseSubcategory5 = Subcategories("Toiletries")
    private val databaseSubcategory6 = Subcategories("Clothes")
    private val subcategoriesList1 = arrayListOf(databaseSubcategory1, databaseSubcategory2)
    private val subcategoriesList2 = arrayListOf(databaseSubcategory3, databaseSubcategory4)
    private val subcategoriesList3 = arrayListOf(databaseSubcategory5, databaseSubcategory6)

    // Mock Categories
    private val databaseCategory1 = Categories("Savings", subcategoriesList1)
    private val databaseCategory2 = Categories("Frequent", subcategoriesList2)
    private val databaseCategory3 = Categories("Shopping", subcategoriesList3)

    fun initializeMockDatabase() {

        // Initialize Budget
        databaseBudget.accounts = arrayListOf(databaseAccount)
        databaseBudget.categories = arrayListOf(databaseCategory1, databaseCategory2, databaseCategory3)

        // Initialize Accounts
        databaseAccount.transactions = transactionsList
    }

    fun getMockBudget(): Budgets {
        return databaseBudget
    }

}