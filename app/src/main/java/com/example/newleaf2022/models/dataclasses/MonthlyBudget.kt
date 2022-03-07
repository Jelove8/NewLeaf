package com.example.newleaf2022.models.dataclasses

import java.time.Month
import java.time.Year

data class MonthlyBudget(private var month: Month,
                         private var year: Year
                         ) {
    private lateinit var categories: Categories

    //
}
