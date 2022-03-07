package com.example.newleaf2022.models.dataclasses

import java.util.*
import kotlin.collections.ArrayList

data class FiscalYear(private val year: Int,
                      private val monthlyBudgets: ArrayList<ArrayList<Categories>> = arrayListOf(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf()),
                      ) {
}

