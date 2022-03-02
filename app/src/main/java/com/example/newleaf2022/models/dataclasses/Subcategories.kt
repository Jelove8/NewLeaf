package com.example.newleaf2022.models.dataclasses

import android.view.SurfaceControl

data class Subcategories(private var name: String?,
                         private var assigned: Double = 0.00,
                         private var available: Double = 0.00,
                         private var transactions: ArrayList<Transactions> = arrayListOf()) {

    fun setName(newName: String) {
        name = newName
    }
    fun getName(): String? {
        return name
    }

    fun setAssigned(newAssigned: Double) {
        assigned = newAssigned
    }
    fun getAssigned(): Double {
        return assigned
    }

    fun setAvailable(newAvailable: Double) {
        available = newAvailable
    }
    fun getAvailable(): Double {
        return available
    }
    fun addTransaction(newTransaction: Transactions) {
        transactions.add(newTransaction)
    }
    fun getTransactions(): ArrayList<Transactions> {
        return transactions
    }
}
