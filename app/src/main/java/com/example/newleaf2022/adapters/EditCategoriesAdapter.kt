package com.example.newleaf2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.models.dataclasses.Category

class EditCategoriesAdapter(private var allCategories: MutableList<Category>,
                            private val categoryPositions: MutableList<Int>
                            ) : RecyclerView.Adapter<EditCategoriesAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val categoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Category)
        val categoryTV: TextView = itemView.findViewById(R.id.tv_Category)
        private val categoryLL1: LinearLayout = itemView.findViewById(R.id.ll_CategoryA)
        private val categoryLL2: LinearLayout = itemView.findViewById(R.id.ll_CategoryB)

        val subcategoryConstraint: LinearLayout = itemView.findViewById(R.id.cnst_Subcategory)
        val subcategoryTV: TextView = itemView.findViewById(R.id.tv_Subcategory)
        private val subAssigned: TextView = itemView.findViewById(R.id.tv_SubAssigned)
        private val subAvailable: TextView = itemView.findViewById(R.id.tv_SubAvailable)

        private val miscButtonsConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_categoryMiscButtons)
        val btnAddSubcategory: Button = itemView.findViewById(R.id.btn_addSubcategory)
        private val btnDeleteSubcategory: Button = itemView.findViewById(R.id.btn_deleteSubcategory)
        val btnDeleteCategory: Button = itemView.findViewById(R.id.btn_deleteCategory)
        val btnReorderCategory: Button = itemView.findViewById(R.id.btn_reorderCategory)
        private val btnReorderSubcategory: Button = itemView.findViewById(R.id.btn_reorderSubcategory)

        init {
            categoryLL1.visibility = View.GONE
            categoryLL2.visibility = View.GONE
            subAssigned.visibility = View.GONE
            subAvailable.visibility = View.GONE
            miscButtonsConstraint.visibility = View.VISIBLE
            btnDeleteSubcategory.visibility = View.VISIBLE
            btnReorderSubcategory.visibility = View.VISIBLE
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories,parent,false)
        return CategoryViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: EditCategoriesAdapter.CategoryViewHolder, position: Int) {
        // Populating unassigned, category, and subcategory views
        val currentItem = allCategories[position]
        if (currentItem.getCategoryType()) {
            // If the current item is a category...
            holder.subcategoryConstraint.visibility = View.GONE
            holder.categoryTV.text = currentItem.getName()
        }
        else {
            // Else if the current item is a subcategory...
            holder.categoryConstraint.visibility = View.GONE
            holder.subcategoryTV.text = currentItem.getName()
        }

    }

    override fun getItemCount(): Int {
        return allCategories.size
    }
}