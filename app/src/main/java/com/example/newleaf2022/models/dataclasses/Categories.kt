package com.example.newleaf2022.models.dataclasses

data class Categories(private var name: String?,
                      private var assigned: Double = 0.00,
                      private var available: Double = 0.00,
                      private var transactions: ArrayList<Transactions>? = null,
                      private var categoryType: Boolean = true  // True = category, False = subcategory
                      ) {

    private var subcategories: ArrayList<Categories> = arrayListOf()

    fun setName(newName: String) {
        name = newName
    }
    fun getName(): String? {
        return name
    }

    fun setAssigned(newAssigned: Double) {
        assigned = newAssigned
    }
    fun getAssigned(): Double {
        return assigned
    }

    fun setAvailable(newAvailable: Double) {
        available = newAvailable
    }
    fun getAvailable(): Double {
        return available
    }

    fun setSubcategories(newSubcategories: ArrayList<Categories>) {
        subcategories = newSubcategories
    }
    fun getSubcategories(): ArrayList<Categories> {
        return subcategories
    }
    fun addSubcategory(newSubcategory: Categories) {
        subcategories.add(newSubcategory)
    }
    fun editSubcategory(newSubcategory: Categories, oldSubcategory: Categories) {
        for ((i,item) in subcategories.withIndex()) {
            if (item == oldSubcategory) {
                subcategories[i] = newSubcategory
            }
        }
    }
    fun deleteSubcategory(oldSubcategory: Categories) {
        subcategories.remove(oldSubcategory)
    }

    fun addTransaction(newTransaction: Transactions) {
        transactions!!.add(newTransaction)
    }
    fun getTransactions(): ArrayList<Transactions>? {
        return transactions
    }

    fun getCategoryType(): Boolean {
        return categoryType
    }
}

