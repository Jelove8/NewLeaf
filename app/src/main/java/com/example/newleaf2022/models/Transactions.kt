package com.example.newleaf2022.models

data class Transactions(var amount: Double = 0.00,
                        var payee: String = "Unassigned",
                        var subcategory: String,
                        var cleared: Boolean = false,
                        var memo: String? = null)

