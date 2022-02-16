package com.example.newleaf2022.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.viewmodels.Categories

class CategoryAdapter(private val categories: ArrayList<Categories>) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    class BudgetsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val mainCategory: TextView = itemView.findViewById(R.id.mainCategoryTV)
        val constraint1: ConstraintLayout = itemView.findViewById(R.id.categoriesConstraint)
        val recycler: RecyclerView = itemView.findViewById(R.id.vhCategoriesRecycler)
        val totalAssigned: EditText = itemView.findViewById(R.id.outputTotalAssigned)
        val totalAvailable: EditText = itemView.findViewById(R.id.outputTotalAvailable)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)

        return BudgetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {

        if (categories[0].name.contentEquals("NULL!")) {
            holder.constraint1.visibility = View.GONE
            holder.recycler.visibility = View.GONE
        }
        else {
            holder.mainCategory.text = categories[position].name

            holder.recycler.apply {
                layoutManager = LinearLayoutManager(context)
                visibility = View.VISIBLE
            }
            holder.recycler.adapter = SubcategoryAdapter(categories[position].subcategories)
        }

    }

    override fun getItemCount(): Int {
        return categories.size
    }
}