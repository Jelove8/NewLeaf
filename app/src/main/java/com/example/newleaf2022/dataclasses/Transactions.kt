package com.example.newleaf2022.dataclasses

import com.example.newleaf2022.dataclasses.Accounts
import java.util.*

data class Transactions(var sign: Boolean = false,
                        var amount: Double = 0.00,
                        var payee: String = "Unassigned",
                        var account: String,
                        var subcategory: String,
                        var cleared: Boolean = false,
                        var memo: String? = null)

