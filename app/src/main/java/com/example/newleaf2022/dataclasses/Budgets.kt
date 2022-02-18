package com.example.newleaf2022.dataclasses

data class Budgets(val name: String,
                   var unassigned: Double = 0.00,
                   var categories: ArrayList<Categories> = arrayListOf(),
                   var accounts: ArrayList<Accounts> = arrayListOf())