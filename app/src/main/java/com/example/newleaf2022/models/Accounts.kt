package com.example.newleaf2022.models

import kotlin.collections.ArrayList

data class Accounts(val name: String,
                    val type: String,
                    val balance: Double,
                    var transactions: ArrayList<Transactions> = arrayListOf()) {


}
