package com.example.newleaf2022.models

import com.example.newleaf2022.models.dataclasses.*


class MockDatabase {

    // Data for March

    private val subcategory1 = Category("Rent", 1000.00, 1000.00, null, false)
    private val subcategory2 = Category("Student Loans", 300.00, 300.00, null, false)
    private val subcategory3 = Category("Groceries", 200.00, 200.00, null, false)
    private val subcategory4 = Category("Gas", 120.00, 120.00, null, false)
    private val subcategory5 = Category("Toiletries", 30.00, 30.00, null, false)
    private val subcategory6 = Category("Clothes", 100.00, 100.00, null, false)

    private val category1 = Category("Savings", 1300.00, 1300.00)
    private val category2 = Category("Frequent", 320.00, 320.00)
    private val category3 = Category("Shopping", 130.00, 130.00)

    private val account1 = Accounts("Checkings", "Checkings", 3000.00)

    private val budget0 = Budgets("Test Budget", 1250.00)

    private val user0 = Users("Anjelo", "password")

    // Data for previous months
    private val subcategoryB1 = Category("Rent", 0.00, 0.00, null, false)
    private val subcategoryB2 = Category("Student Loans", 0.00, 0.00, null, false)
    private val subcategoryB3 = Category("Groceries", 0.00, 0.00, null, false)
    private val subcategoryB4 = Category("Gas", 0.00, 0.00, null, false)
    private val subcategoryB5 = Category("Toiletries", 0.00, 0.00, null, false)
    private val subcategoryB6 = Category("Clothes", 0.00, 0.00, null, false)

    private val categoryB1 = Category("Savings", 0.00, 0.00)
    private val categoryB2 = Category("Frequent", 0.00, 0.00)
    private val categoryB3 = Category("Shopping", 0.00, 0.00)


    // Data for April
    private val subcategoryC1 = Category("Rent", 0.00, 1000.00, null, false)
    private val subcategoryC2 = Category("Student Loans", 0.00, 300.00, null, false)
    private val subcategoryC3 = Category("Groceries", 0.00, 200.00, null, false)
    private val subcategoryC4 = Category("Gas", 0.00, 120.00, null, false)
    private val subcategoryC5 = Category("Toiletries", 0.00, 30.00, null, false)
    private val subcategoryC6 = Category("Clothes", 0.00, 100.00, null, false)

    private val categoryC1 = Category("Savings", 0.00, 1300.00)
    private val categoryC2 = Category("Frequent", 0.00, 320.00)
    private val categoryC3 = Category("Shopping", 0.00, 1300.00)




    fun getMockUser(): Users {

        category1.setSubcategories(mutableListOf(subcategory1, subcategory2))
        category2.setSubcategories(mutableListOf(subcategory3, subcategory4))
        category3.setSubcategories(mutableListOf(subcategory5, subcategory6))

        categoryB1.setSubcategories(mutableListOf(subcategoryB1, subcategoryB2))
        categoryB2.setSubcategories(mutableListOf(subcategoryB3, subcategoryB4))
        categoryB3.setSubcategories(mutableListOf(subcategoryB5, subcategoryB6))

        categoryC1.setSubcategories(mutableListOf(subcategoryC1, subcategoryC2))
        categoryC2.setSubcategories(mutableListOf(subcategoryC3, subcategoryC4))
        categoryC3.setSubcategories(mutableListOf(subcategoryC5, subcategoryC6))

        budget0.setAccounts(mutableListOf(account1))
        budget0.setTransactions(mutableListOf())

        val fiscalYear2022 = FiscalYear(2022, mutableListOf(mutableListOf(categoryB1, categoryB2, categoryB3),mutableListOf(categoryB1, categoryB2, categoryB3),mutableListOf(category1, category2, category3),mutableListOf(categoryC1, categoryC2, categoryC3)))
        budget0.addYearlyBudget(fiscalYear2022)


        user0.addUserBudget(budget0)
        user0.setLastDisplayedBudgetPosition(0)

        return user0
    }
}