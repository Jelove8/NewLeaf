package com.example.newleaf2022.models.dataclasses

data class Budgets(
    private var name: String,
    private var unassigned: Double = 0.00,
    private var yearlyBudgets: MutableList<FiscalYear> = mutableListOf()
) {
    private lateinit var monthlyBudgets: MutableList<MonthlyBudget>
    private lateinit var accounts: MutableList<Accounts>
    private lateinit var transactions: MutableList<Transactions>



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

    fun getMonthlyBudgets(): MutableList<MonthlyBudget> {
        return monthlyBudgets
    }
    fun setMonthlyBudget(newMonthlyBudget: MonthlyBudget) {

    }




    fun getYearlyBudgets(): MutableList<FiscalYear> {
        return yearlyBudgets
    }
    fun addYearlyBudget(newYearlyBudgets: FiscalYear) {
        yearlyBudgets.add(newYearlyBudgets)
    }





    fun setAccounts(newAccounts: MutableList<Accounts>) {
        accounts = newAccounts
    }

    fun getAccounts(): MutableList<Accounts> {
        return accounts
    }

    fun setTransactions(newTransactions: MutableList<Transactions>) {
        transactions = newTransactions
    }

    fun getTransactions(): MutableList<Transactions> {
        return transactions
    }
}