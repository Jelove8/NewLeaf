package com.example.newleaf2022.models.dataclasses

data class Budgets(private var name: String,
                   private var unassigned: Double = 0.00, ) {

    private lateinit var categories: ArrayList<Categories>
    private lateinit var accounts: ArrayList<Accounts>
    private lateinit var transactions: ArrayList<Transactions>

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