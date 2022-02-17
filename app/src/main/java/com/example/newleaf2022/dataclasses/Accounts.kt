package com.example.newleaf2022.dataclasses

data class Accounts(val name: String,
                    val type: String,
                    val balance: Double) {
    lateinit var transactions: ArrayList<Transactions>
}
