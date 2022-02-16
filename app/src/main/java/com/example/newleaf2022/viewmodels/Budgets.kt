package com.example.newleaf2022.viewmodels

data class Budgets(val name: String,
                   val dateCreated: String) {

    lateinit var categories: ArrayList<Categories>
    lateinit var accounts: ArrayList<Accounts>
}
