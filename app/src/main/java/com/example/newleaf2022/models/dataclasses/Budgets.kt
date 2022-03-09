package com.example.newleaf2022.models.dataclasses

data class Budgets(private var name: String,
                   private var unassigned: Double = 0.00,
                   private var yearlyBudgets: ArrayList<FiscalYear> = arrayListOf()
                   ) {

    private lateinit var mainCategories: ArrayList<Categories>
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

    fun setMainCategories(newCategories: ArrayList<Categories>) {
        mainCategories = newCategories
    }
    fun getMainCategories(): ArrayList<Categories> {
        return mainCategories
    }
    fun addEmptyCategory() {
        mainCategories.add(0,Categories(""))
    }
    fun removeCategory(position: Int) {
        mainCategories.removeAt(position)
    }
    fun removeSubcategory(categoryPosition: Int, subcategoryPosition: Int) {
        mainCategories[categoryPosition].getSubcategories().removeAt(subcategoryPosition)
    }
    fun editCategories(newCategory: Categories, oldCategory: Categories) {
        for ((i,item) in mainCategories.withIndex()) {
            if (item == oldCategory) {
                mainCategories[i] = newCategory
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