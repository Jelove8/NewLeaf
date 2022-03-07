package com.example.newleaf2022.models.dataclasses

data class Budgets(private var name: String,
                   private var unassigned: Double = 0.00, ) {

    private lateinit var categories: ArrayList<Categories>
    private lateinit var accounts: ArrayList<Accounts>
    private lateinit var transactions: ArrayList<Transactions>

    private lateinit var yearlyBudgets: ArrayList<FiscalYear>

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

    data class FiscalYear(private val year: Int,
                          private val januaryBudget: ArrayList<Categories> = arrayListOf(),
                          private val februaryBudget: ArrayList<Categories> = arrayListOf(),
                          private val marchBudget: ArrayList<Categories> = arrayListOf(),
                          private val aprilBudget: ArrayList<Categories> = arrayListOf(),
                          private val mayBudget: ArrayList<Categories> = arrayListOf(),
                          private val juneBudget: ArrayList<Categories> = arrayListOf(),
                          private val julyBudget: ArrayList<Categories> = arrayListOf(),
                          private val augustBudget: ArrayList<Categories> = arrayListOf(),
                          private val septemberBudget: ArrayList<Categories> = arrayListOf(),
                          private val octoberBudget: ArrayList<Categories> = arrayListOf(),
                          private val novemberBudget: ArrayList<Categories> = arrayListOf(),
                          private val decemberBudget: ArrayList<Categories> = arrayListOf()
                          ) {
        fun getYear(): Int {
            return year
        }

        fun getMonthlyBudget(month: Int): ArrayList<Categories> {
            return when (month) {
                1 -> januaryBudget
                2 -> februaryBudget
                3 -> marchBudget
                4 -> aprilBudget
                5 -> mayBudget
                6 -> juneBudget
                7 -> julyBudget
                8 -> augustBudget
                9 -> septemberBudget
                10 -> octoberBudget
                11 -> novemberBudget
                12 -> decemberBudget
                else -> arrayListOf()
            }
        }
    }

}