package com.example.newleaf2022.models.dataclasses

data class Categories(val name: String,
                      var totalAssigned: Double = 0.00,
                      var totalAvailable: Double = 0.00,
                      var subcategories: ArrayList<Subcategories> = arrayListOf())

