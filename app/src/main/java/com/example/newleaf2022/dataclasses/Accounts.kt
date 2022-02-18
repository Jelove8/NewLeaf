package com.example.newleaf2022.dataclasses

import java.util.*
import kotlin.collections.ArrayList

data class Accounts(val name: String,
                    val type: String,
                    val balanceSign: Boolean = false,
                    val balance: Double,
                    var transactions: ArrayList<Transactions> = arrayListOf()) {

}
