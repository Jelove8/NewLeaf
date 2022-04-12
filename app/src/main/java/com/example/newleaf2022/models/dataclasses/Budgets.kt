package com.example.newleaf2022.models.dataclasses

data class Users(
    var userName: String,
    var userPassword: String? = null,
    var userBudgets: MutableList<Budgets> = mutableListOf(),
    var currentlyDisplayedBudgetIndex: Int = 0
)

data class Budgets(
    var bdgtName: String,
    var bdgtUnassignedMoney: Double = 0.00,
    var bdgtAllMonthlyBudgets: MutableList<MonthlyBudget> = mutableListOf(),
    var bdgtAllAccounts: MutableList<Accounts> = mutableListOf(),
    var bdgtAllTransactions: MutableList<Transactions> = mutableListOf(),
    var bdgtAllCategories: MutableList<Category> = mutableListOf(),
)

data class MonthlyBudget(
    val bdgtYear: Int,
    val bdgtMonth: Int, // 0 = January ... 11 = December
    val bdgtCategories: MutableList<Category> = mutableListOf()
)

data class Accounts(
    var acctName: String,
    var acctType: String,
    var acctBalance: Double = 0.00,
    var acctTransactionIDs: MutableList<String> = mutableListOf()
)

data class Category(
    var catName: String?,
    var catType: Boolean = true,  // True = category, False = subcategory
    var catAssignedMoney: Double = 0.00,
    var catAvailableMoney: Double = 0.00,
    var subcategories: MutableList<Category> = mutableListOf()
)

data class Transactions(
    var amount: Double = 0.00,
    var payee: String? = null,
    var subcategory: String? = null,
    var cleared: Boolean = false,
    var memo: String? = null
)



