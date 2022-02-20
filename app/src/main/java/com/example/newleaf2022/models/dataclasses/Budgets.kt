package com.example.newleaf2022.models.dataclasses

data class Budgets(val name: String,
                   var unassigned: Double = 0.00,
                   var categories: ArrayList<Categories>,
                   var accounts: ArrayList<Accounts> = arrayListOf(),
                   var transactions: ArrayList<Transactions> = arrayListOf())