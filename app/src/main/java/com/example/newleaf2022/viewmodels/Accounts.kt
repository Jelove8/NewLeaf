package com.example.newleaf2022.viewmodels

data class Accounts(val name: String,
                    val type: String,
                    val initialBalance: Double) {
    lateinit var transactions: ArrayList<Transactions>
}
