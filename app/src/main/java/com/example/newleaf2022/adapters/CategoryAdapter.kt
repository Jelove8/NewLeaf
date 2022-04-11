package com.example.newleaf2022.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.MainActivity
import com.example.newleaf2022.NumpadFragment
import com.example.newleaf2022.R
import com.example.newleaf2022.models.dataclasses.Category
import com.example.newleaf2022.viewmodels.BudgetsViewModel


class CategoryAdapter(private var allCategories: MutableList<Category>, private val mainActivity: MainActivity, private val categoryPositions: MutableList<Int>, private val budgetsVM: BudgetsViewModel, private val readyToAssignTV: TextView) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    fun updateUnassignedTV(newUnassigned: Double) {
        readyToAssignTV.text = newUnassigned.toString()
    }

    class BudgetsViewHolder(ItemView: View, mainActivity: MainActivity, budgetsVM: BudgetsViewModel, allCategories: MutableList<Category>, categoryPositions: MutableList<Int>, unassignedTV: TextView, adapter: CategoryAdapter) : RecyclerView.ViewHolder(ItemView) {

        val categoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Category)
        val categoryTV: TextView = itemView.findViewById(R.id.tv_Category)
        val totalAssigned: TextView = itemView.findViewById(R.id.tv_Assigned)
        val totalAvailable: TextView = itemView.findViewById(R.id.tv_Available)

        val subcategoryConstraint: LinearLayout = itemView.findViewById(R.id.cnst_Subcategory)
        val subcategoryTV: TextView = itemView.findViewById(R.id.tv_Subcategory)
        val subAssigned: TextView = itemView.findViewById(R.id.tv_SubAssigned)
        val subAvailable: TextView = itemView.findViewById(R.id.tv_SubAvailable)

        private var previousCategoryPosition: Int = 0
        lateinit var selectedSubcategory: Category
        lateinit var selectedCategory: Category

        init {
            for (index in categoryPositions) {
                if (bindingAdapterPosition == index) {
                    previousCategoryPosition = index
                }
            }
            subAssigned.setOnClickListener {
                selectedSubcategory = allCategories[bindingAdapterPosition]
                for (category in allCategories) {
                    if (category.getCategoryType()) {
                        for (subcategory in category.getSubcategories()) {
                            if (subcategory == selectedSubcategory) {
                                selectedCategory = category
                            }
                        }
                    }
                }
                mainActivity.changeFragment("numpad", NumpadFragment())
                budgetsVM.selectCategoryViewHolder(adapter, this)
            }
        }

        fun updateViewHolder(adapter: CategoryAdapter) {
            adapter.notifyItemChanged(bindingAdapterPosition)
            adapter.notifyItemChanged(previousCategoryPosition)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)

        return BudgetsViewHolder(
            view,
            mainActivity,
            budgetsVM,
            allCategories,
            categoryPositions,
            readyToAssignTV,
            this
        )
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {
        // Populating unassigned, category, and subcategory views
        val currentItem = allCategories[position]
        if (currentItem.getCategoryType()) {
            // If the current item is a category...
            holder.subcategoryConstraint.visibility = View.GONE
            holder.categoryTV.text = currentItem.getName()
            holder.totalAssigned.text = currentItem.getAssigned().toString()
            holder.totalAvailable.text = currentItem.getAvailable().toString()
        }
        else {
            // Else if the current item is a subcategory...
            holder.categoryConstraint.visibility = View.GONE
            holder.subcategoryTV.text = currentItem.getName()
            holder.subAssigned.text = currentItem.getAssigned().toString()
            holder.subAvailable.text = currentItem.getAvailable().toString()
        }


    }

    override fun getItemCount(): Int {
        return allCategories.size
    }


}