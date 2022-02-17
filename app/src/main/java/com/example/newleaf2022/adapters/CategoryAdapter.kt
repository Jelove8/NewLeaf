package com.example.newleaf2022.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.dataclasses.Categories

class CategoryAdapter(private val categories: ArrayList<Categories>) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    class BudgetsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val mainCategory: TextView = itemView.findViewById(R.id.mainCategoryTV)
        val categoriesConstraint: ConstraintLayout = itemView.findViewById(R.id.categoriesConstraint)
        val subcategoriesConstraint: LinearLayout = itemView.findViewById(R.id.subcategoriesLinearLayout)
        val totalAssigned: EditText = itemView.findViewById(R.id.outputTotalAssigned)
        val totalAvailable: EditText = itemView.findViewById(R.id.outputTotalAvailable)

        val subcategory1: ConstraintLayout = itemView.findViewById(R.id.subcategory1)
        val subcategory2: ConstraintLayout = itemView.findViewById(R.id.subcategory2)
        val subcategory3: ConstraintLayout = itemView.findViewById(R.id.subcategory3)
        val subcategory4: ConstraintLayout = itemView.findViewById(R.id.subcategory4)
        val subcategory5: ConstraintLayout = itemView.findViewById(R.id.subcategory5)
        val subcategory6: ConstraintLayout = itemView.findViewById(R.id.subcategory6)
        val subcategory7: ConstraintLayout = itemView.findViewById(R.id.subcategory7)
        val subcategory8: ConstraintLayout = itemView.findViewById(R.id.subcategory8)
        val subcategory9: ConstraintLayout = itemView.findViewById(R.id.subcategory9)
        val subcategory10: ConstraintLayout = itemView.findViewById(R.id.subcategory10)
        val subcategory11: ConstraintLayout = itemView.findViewById(R.id.subcategory11)
        val subcategory12: ConstraintLayout = itemView.findViewById(R.id.subcategory12)
        val subcategory13: ConstraintLayout = itemView.findViewById(R.id.subcategory13)
        val subcategory14: ConstraintLayout = itemView.findViewById(R.id.subcategory14)
        val subcategory15: ConstraintLayout = itemView.findViewById(R.id.subcategory15)
        val subcategory16: ConstraintLayout = itemView.findViewById(R.id.subcategory16)

        val sub1: TextView = itemView.findViewById(R.id.sub1)
        val sub2: TextView = itemView.findViewById(R.id.sub2)
        val sub3: TextView = itemView.findViewById(R.id.sub3)
        val sub4: TextView = itemView.findViewById(R.id.sub4)
        val sub5: TextView = itemView.findViewById(R.id.sub5)
        val sub6: TextView = itemView.findViewById(R.id.sub6)
        val sub7: TextView = itemView.findViewById(R.id.sub7)
        val sub8: TextView = itemView.findViewById(R.id.sub8)
        val sub9: TextView = itemView.findViewById(R.id.sub9)
        val sub10: TextView = itemView.findViewById(R.id.sub10)
        val sub11: TextView = itemView.findViewById(R.id.sub11)
        val sub12: TextView = itemView.findViewById(R.id.sub12)
        val sub13: TextView = itemView.findViewById(R.id.sub13)
        val sub14: TextView = itemView.findViewById(R.id.sub14)
        val sub15: TextView = itemView.findViewById(R.id.sub15)
        val sub16: TextView = itemView.findViewById(R.id.sub16)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)

        return BudgetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {

        fun hideSubcategories(interval: Int) {
            when (interval) {
                1 -> {
                    holder.subcategory2.visibility = View.GONE
                    holder.subcategory3.visibility = View.GONE
                    holder.subcategory4.visibility = View.GONE
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                2 -> {
                    holder.subcategory3.visibility = View.GONE
                    holder.subcategory4.visibility = View.GONE
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                3 -> {
                    holder.subcategory4.visibility = View.GONE
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                4 -> {
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                5 -> {
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                6 -> {
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                7 -> {
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                8 -> {
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                9 -> {
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                10 -> {
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                11 -> {
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                12 -> {
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                13 -> {
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                14 -> {
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE
                }
                15 -> {
                    holder.subcategory16.visibility = View.GONE
                }
                16 -> {
                    // all visible
                }
                else -> {
                    holder.subcategoriesConstraint.visibility = View.GONE
                }
            }
        }

        hideSubcategories(categories[position].subcategories.size)
        if (categories[position].name.contentEquals("NULL!")) {
            holder.categoriesConstraint.visibility = View.GONE
            holder.subcategoriesConstraint.visibility = View.GONE
        }
        else {
            holder.mainCategory.text = categories[position].name
            val limit = categories[position].subcategories.size
            for (i in 0 until limit) {
                val name = categories[position].subcategories[i].name
                when (i) {
                    0 -> {
                        holder.sub1.text = name
                    }
                    1 -> {
                        holder.sub2.text = name
                    }
                    2 -> {
                        holder.sub3.text = name
                    }
                    3 -> {
                        holder.sub4.text = name
                    }
                    4 -> {
                        holder.sub5.text = name
                    }
                    5 -> {
                        holder.sub6.text = name
                    }
                    6 -> {
                        holder.sub7.text = name
                    }
                    7 -> {
                        holder.sub8.text = name
                    }
                    8 -> {
                        holder.sub9.text = name
                    }
                    9 -> {
                        holder.sub10.text = name
                    }
                    10 -> {
                        holder.sub11.text = name
                    }
                    11 -> {
                        holder.sub12.text = name
                    }
                    12 -> {
                        holder.sub13.text = name
                    }
                    13 -> {
                        holder.sub14.text = name
                    }
                    14 -> {
                        holder.sub15.text = name
                    }
                    15 -> {
                        holder.sub16.text = name
                    }
                    else -> {}
                }
            }
        }
        Log.d("Meow", "Size of subcategoriesList: ${categories[position].subcategories.size}" )

    }

    override fun getItemCount(): Int {
        return categories.size
    }
}