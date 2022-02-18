package com.example.newleaf2022.models

import com.example.newleaf2022.dataclasses.*


class MockDatabase {


    // Mock User
    private val anjelo = Users("Anjelo", "1.Ilfitmourirparlepee")

    // Mock Budget & Account
    private lateinit var databaseBudget : Budgets

    // Mock Accounts
    private val databaseAccount1 = Accounts("Checkings", "Checkings",true, 3000.00 )
    private val databaseAccount2 = Accounts("Credit", "Credit", true, 0.00)

    // Mock Transactions
    private val databaseTransaction1 = Transactions(false, 150.00, "FAFSA", "Checkings", "Student Loans" , true)
    private val databaseTransaction2 = Transactions(false, 41.17, "Royal Farms", "Credit", "Gas",  true)
    private val databaseTransaction3 = Transactions(false, 20.57, "Target", "Checkings", "Clothes" , true, "Bought jeans")
    private val databaseTransaction4 = Transactions(false, 36.17, "Royal Farms", "Credit", "Gas")
    private val databaseTransaction5 = Transactions(true, 654.18, "Income", "Checkings", "Unassigned")
    private val databaseTransactions1 = arrayListOf(databaseTransaction1, databaseTransaction3, databaseTransaction5)
    private val databaseTransactions2 = arrayListOf(databaseTransaction2, databaseTransaction4)

    // Mock Subcategories
    private val databaseSubcategory1 = Subcategories("Rent", 1000.00, 1000.00)
    private val databaseSubcategory2 = Subcategories("Student Loans", 300.00, 300.00)
    private val databaseSubcategory3 = Subcategories("Groceries", 200.00, 200.00)
    private val databaseSubcategory4 = Subcategories("Gas", 120.00, 120.00)
    private val databaseSubcategory5 = Subcategories("Toiletries", 30.00, 30.00)
    private val databaseSubcategory6 = Subcategories("Clothes", 100.00, 100.00)
    private val subcategoriesList1 = arrayListOf(databaseSubcategory1, databaseSubcategory2)
    private val subcategoriesList2 = arrayListOf(databaseSubcategory3, databaseSubcategory4)
    private val subcategoriesList3 = arrayListOf(databaseSubcategory5, databaseSubcategory6)

    // Mock Categories
    private val databaseCategory1 = Categories("Savings", 1300.00, 1300.00)
    private val databaseCategory2 = Categories("Frequent", 320.00, 320.00)
    private val databaseCategory3 = Categories("Shopping", 130.00, 130.00)
    private val databaseCategories = arrayListOf(databaseCategory1, databaseCategory2, databaseCategory3)

    fun getMockUser(): Users {
        databaseBudget = Budgets("Test Budget", 2593.73)


        //Initializing Accounts
        databaseAccount1.transactions = databaseTransactions1
        databaseAccount2.transactions = databaseTransactions2
        databaseBudget .accounts = arrayListOf(databaseAccount1, databaseAccount2)

        //Initializing Categories
        databaseCategory1.subcategories = subcategoriesList1
        databaseCategory2.subcategories = subcategoriesList2
        databaseCategory3.subcategories = subcategoriesList3
        databaseBudget.categories = databaseCategories

        anjelo.setBudgets(arrayListOf(databaseBudget))

        return anjelo
    }
}