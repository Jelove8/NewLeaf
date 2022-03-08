package com.example.newleaf2022.models.dataclasses

import java.util.*
import kotlin.collections.ArrayList

data class FiscalYear(private val year: Int,
                      private val monthlyBudgets: ArrayList<ArrayList<Categories>> = arrayListOf(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf()),
                      ) {

    fun getMonthlyBudgets(): ArrayList<ArrayList<Categories>> {
        return monthlyBudgets
    }

    fun getYear(): Int {
        return year
    }

    fun setMonthlyBudget(month: Int, newCategories: ArrayList<Categories>) {
        monthlyBudgets[month] = newCategories
    }
}

