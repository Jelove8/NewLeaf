package com.example.newleaf2022.viewmodels

data class Accounts(val name: String, val type: String, val balance: Double) {
    private lateinit var trees: ArrayList<Trees>
}
