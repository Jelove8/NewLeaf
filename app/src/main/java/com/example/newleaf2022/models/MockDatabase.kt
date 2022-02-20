package com.example.newleaf2022.models

import com.example.newleaf2022.models.dataclasses.*


class MockDatabase {

    private val subcategory1 = Subcategories("Rent", 1000.00, 1000.00)
    private val subcategory2 = Subcategories("Student Loans", 300.00, 300.00)
    private val subcategory3 = Subcategories("Groceries", 200.00, 200.00)
    private val subcategory4 = Subcategories("Gas", 120.00, 120.00)
    private val subcategory5 = Subcategories("Toiletries", 30.00, 30.00)
    private val subcategory6 = Subcategories("Clothes", 100.00, 100.00)

    private val category1 = Categories("Savings", 1300.00, 1300.00)
    private val category2 = Categories("Frequent", 320.00, 320.00)
    private val category3 = Categories("Shopping", 130.00, 130.00)

    private val account1 = Accounts("Checkings", "Checkings", 3000.00)
    private val account2 = Accounts("Credit", "Credit",  0.00)

    private val budget0 = Budgets("Test Budget", 1250.00)

    private val user0 = Users("Anjelo", "password")



    fun getMockUser(): Users {

        category1.setSubcategories(arrayListOf(subcategory1, subcategory2))
        category2.setSubcategories(arrayListOf(subcategory3, subcategory4))
        category3.setSubcategories(arrayListOf(subcategory5, subcategory6))

        budget0.setCategories(arrayListOf(category1, category2, category3))
        budget0.setAccounts(arrayListOf(account1, account2))
        budget0.setTransactions(arrayListOf())

        user0.setBudgets(arrayListOf(budget0))
        user0.setCurrentBudget(budget0)

        return user0
    }
}