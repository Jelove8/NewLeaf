package com.example.newleaf2022.models.dataclasses

data class Categories(private var name: String,
                      private var assigned: Double = 0.00,
                      private var available: Double = 0.00) {

    private lateinit var subcategories: ArrayList<Subcategories>

    fun setName(newName: String) {
        name = newName
    }
    fun getName(): String {
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

    fun setSubcategories(newSubcategories: ArrayList<Subcategories>) {
        subcategories = newSubcategories
    }
    fun getSubcategories(): ArrayList<Subcategories> {
        return subcategories
    }
    fun addSubcategory(newSubcategory: Subcategories) {
        subcategories.add(newSubcategory)
    }
    fun editSubcategory(newSubcategory: Subcategories, oldSubcategory: Subcategories) {
        for ((i,item) in subcategories.withIndex()) {
            if (item == oldSubcategory) {
                subcategories[i] = newSubcategory
            }
        }
    }
    fun deleteSubcategory(oldSubcategory: Subcategories) {
        subcategories.remove(oldSubcategory)
    }
}

