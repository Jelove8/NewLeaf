package com.example.newleaf2022.dataclasses

data class Categories(val name: String,
                      val subcategories: ArrayList<Subcategories>,
                      val totalAssigned: Double = 0.00,
                      val totalAvailable: Double = 0.00) {

}
