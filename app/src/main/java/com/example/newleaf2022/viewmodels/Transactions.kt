package com.example.newleaf2022.viewmodels

data class Transactions(val type: Int, val amount: Double, val payee: String, val dateCreated: Int, val clearedCheck: Boolean, val memo: String  )
