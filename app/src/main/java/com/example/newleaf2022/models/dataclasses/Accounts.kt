package com.example.newleaf2022.models.dataclasses

import kotlin.collections.ArrayList

data class Accounts(private var name: String,
                    private var type: String,
                    private var balance: Double = 0.00) {

    private lateinit var transactions: ArrayList<Transactions>

    fun setName(newName: String) {
        name = newName
    }
    fun getName(): String {
        return name
    }

    fun setType(newType: String) {
        type = newType
    }
    fun getType(): String {
        return type
    }

    fun setBalance(newBalance: Double) {
        balance = newBalance
    }
    fun getBalance(): Double {
        return balance
    }

    fun setTransactions(newTransactions: ArrayList<Transactions>) {
        transactions = newTransactions
    }
    fun getTransactions(): ArrayList<Transactions> {
        return transactions
    }
    fun addTransaction(newTransaction: Transactions) {
        transactions.add(newTransaction)
    }
    fun editTransaction(newTransaction: Transactions, oldTransaction: Transactions) {
        for ((i,item) in transactions.withIndex()) {
            if (item == oldTransaction) {
                transactions[i] = newTransaction
            }
        }
    }
    fun removeTransaction(oldTransaction: Transactions) {
        transactions.remove(oldTransaction)
    }
}
