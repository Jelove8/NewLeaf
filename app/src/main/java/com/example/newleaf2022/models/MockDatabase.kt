package com.example.newleaf2022.models

import com.example.newleaf2022.models.dataclasses.*


class MockDatabase {

    // Data for March

    private val subcategory1 = Categories("Rent", 1000.00, 1000.00, null, false)
    private val subcategory2 = Categories("Student Loans", 300.00, 300.00, null, false)
    private val subcategory3 = Categories("Groceries", 200.00, 200.00, null, false)
    private val subcategory4 = Categories("Gas", 120.00, 120.00, null, false)
    private val subcategory5 = Categories("Toiletries", 30.00, 30.00, null, false)
    private val subcategory6 = Categories("Clothes", 100.00, 100.00, null, false)

    private val category1 = Categories("Savings", 1300.00, 1300.00)
    private val category2 = Categories("Frequent", 320.00, 320.00)
    private val category3 = Categories("Shopping", 130.00, 130.00)

    private val account1 = Accounts("Checkings", "Checkings", 3000.00)
    private val account2 = Accounts("Credit", "Credit",  0.00)

    private val budget0 = Budgets("Test Budget", 1250.00)

    private val user0 = Users("Anjelo", "password")

    // Data for previous months
    private val subcategoryB1 = Categories("Rent", 0.00, 0.00, null, false)
    private val subcategoryB2 = Categories("Student Loans", 0.00, 0.00, null, false)
    private val subcategoryB3 = Categories("Groceries", 0.00, 0.00, null, false)
    private val subcategoryB4 = Categories("Gas", 0.00, 0.00, null, false)
    private val subcategoryB5 = Categories("Toiletries", 0.00, 0.00, null, false)
    private val subcategoryB6 = Categories("Clothes", 0.00, 0.00, null, false)

    private val categoryB1 = Categories("Savings", 0.00, 0.00)
    private val categoryB2 = Categories("Frequent", 0.00, 0.00)
    private val categoryB3 = Categories("Shopping", 0.00, 0.00)


    // Data for April
    private val subcategoryC1 = Categories("Rent", 0.00, 0.00, null, false)
    private val subcategoryC2 = Categories("Student Loans", 0.00, 0.00, null, false)
    private val subcategoryC3 = Categories("Groceries", 0.00, 0.00, null, false)
    private val subcategoryC4 = Categories("Gas", 0.00, 0.00, null, false)
    private val subcategoryC5 = Categories("Toiletries", 0.00, 0.00, null, false)
    private val subcategoryC6 = Categories("Clothes", 0.00, 0.00, null, false)

    private val categoryC1 = Categories("Savings", 0.00, 0.00)
    private val categoryC2 = Categories("Frequent", 0.00, 0.00)
    private val categoryC3 = Categories("Shopping", 0.00, 0.00)




    fun getMockUser(): Users {

        category1.setSubcategories(arrayListOf(subcategory1, subcategory2))
        category2.setSubcategories(arrayListOf(subcategory3, subcategory4))
        category3.setSubcategories(arrayListOf(subcategory5, subcategory6))

        categoryB1.setSubcategories(arrayListOf(subcategoryB1, subcategoryB2))
        categoryB2.setSubcategories(arrayListOf(subcategoryB3, subcategoryB4))
        categoryB3.setSubcategories(arrayListOf(subcategoryB5, subcategoryB6))

        categoryC1.setSubcategories(arrayListOf(subcategoryC1, subcategoryC2))
        categoryC2.setSubcategories(arrayListOf(subcategoryC3, subcategoryC4))
        categoryC3.setSubcategories(arrayListOf(subcategoryC5, subcategoryC6))

        budget0.setCategories(arrayListOf(category1, category2, category3))
        budget0.setAccounts(arrayListOf(account1, account2))
        budget0.setTransactions(arrayListOf())

        val fiscalYear2022 = FiscalYear(2022, arrayListOf(arrayListOf(categoryB1, categoryB2, categoryB3),arrayListOf(categoryB1, categoryB2, categoryB3),arrayListOf(category1, category2, category3),arrayListOf(categoryC1, categoryC2, categoryC3),arrayListOf(categoryB1, categoryB2, categoryB3), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf() ,
            arrayListOf()))
        budget0.addYearlyBudget(fiscalYear2022)


        user0.setBudgets(arrayListOf(budget0))
        user0.setCurrentBudget(budget0)

        return user0
    }
}