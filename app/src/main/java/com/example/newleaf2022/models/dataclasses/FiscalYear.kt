package com.example.newleaf2022.models.dataclasses

import java.util.*
import kotlin.collections.ArrayList

data class FiscalYear(private val year: Int,
                      private val monthlyBudgets: MutableList<MutableList<Categories>>) {

    fun getMonthlyBudgets(): MutableList<MutableList<Categories>> {
        return monthlyBudgets
    }

    fun getYear(): Int {
        return year
    }

    fun setMonthlyBudget(month: Int, newCategories: MutableList<Categories>) {
        monthlyBudgets[month] = newCategories
    }
}

