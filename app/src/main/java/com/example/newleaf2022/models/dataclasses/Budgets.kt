package com.example.newleaf2022.models.dataclasses

data class Budgets(private var name: String,
                   private var unassigned: Double = 0.00,
                   private var yearlyBudgets: ArrayList<FiscalYear> = arrayListOf()
                   ) {

    private lateinit var categories: ArrayList<Categories>
    private lateinit var accounts: ArrayList<Accounts>
    private lateinit var transactions: ArrayList<Transactions>

    fun getYearlyBudgets(): ArrayList<FiscalYear> {
        return yearlyBudgets
    }
    fun addYearlyBudget(newYearlyBudgets: FiscalYear) {
        yearlyBudgets.add(newYearlyBudgets)
    }

    fun setName(newName: String) {
        name = newName
    }
    fun getName(): String {
        return name
    }

    fun setUnassigned(newValue: Double) {
        unassigned = newValue
    }
    fun getUnassigned(): Double {
        return unassigned
    }

    fun setCategories(newCategories: ArrayList<Categories>) {
        categories = newCategories
    }
    fun getCategories(): ArrayList<Categories> {
        return categories
    }
    fun addEmptyCategory() {
        categories.add(0,Categories(""))
    }
    fun removeCategory(position: Int) {
        categories.removeAt(position)
    }
    fun removeSubcategory(categoryPosition: Int, subcategoryPosition: Int) {
        categories[categoryPosition].getSubcategories().removeAt(subcategoryPosition)
    }
    fun editCategories(newCategory: Categories, oldCategory: Categories) {
        for ((i,item) in categories.withIndex()) {
            if (item == oldCategory) {
                categories[i] = newCategory
            }
        }
    }

    fun setAccounts(newAccounts: ArrayList<Accounts>) {
        accounts = newAccounts
    }
    fun getAccounts(): ArrayList<Accounts> {
        return accounts
    }

    fun setTransactions(newTransactions: ArrayList<Transactions>) {
        transactions = newTransactions
    }
    fun getTransactions(): ArrayList<Transactions> {
        return transactions
    }


}