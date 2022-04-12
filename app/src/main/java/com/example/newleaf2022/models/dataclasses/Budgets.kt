package com.example.newleaf2022.models.dataclasses

data class Budgets(private var name: String,
                   private var unassigned: Double = 0.00,
                   private var yearlyBudgets: ArrayList<FiscalYear> = arrayListOf()
                   ) {

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