package com.example.newleaf2022.dataclasses

import com.example.newleaf2022.dataclasses.Accounts

data class Transactions(val sign: Boolean,
                        val amount: Double,
                        val payee: String,
                        val account: Accounts,
                        val subcategories: String,
                        val dateCreated: String,
                        val clearedCheck: Boolean,
                        val memo: String?)

