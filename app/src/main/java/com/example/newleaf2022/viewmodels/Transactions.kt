package com.example.newleaf2022.viewmodels

data class Transactions(val type: Boolean,
                        val amount: Double,
                        val payee: String,
                        val account: Accounts,
                        val subcategories: String,
                        val dateCreated: String,
                        val clearedCheck: Boolean,
                        val memo: String?) {
}

