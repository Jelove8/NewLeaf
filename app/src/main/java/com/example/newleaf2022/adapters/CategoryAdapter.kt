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


class CategoryAdapter(private var allCategories: MutableList<Category>, private val mainActivity: MainActivity, private val readyToAssignTV: TextView) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    fun updateUnassignedTV(newUnassigned: Double) {
        readyToAssignTV.text = newUnassigned.toString()
    }

    class BudgetsViewHolder(ItemView: View, allCategories: MutableList<Category>,  mainActivity: MainActivity, readyToAssignTV: TextView) : RecyclerView.ViewHolder(ItemView) {

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

            subAssigned.setOnClickListener {
                selectedSubcategory = allCategories[bindingAdapterPosition]
                mainActivity.getInstanceOfViewModel().selectSubcategoryViewHolder()


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
            allCategories,
            mainActivity,
            readyToAssignTV
        )
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {

        // Populating unassigned, category, and subcategory views
        val currentCategory = allCategories[position]

        // Checking if currentCategory is a category or subcategory
        if (currentCategory.catType) {
            holder.subcategoryConstraint.visibility = View.GONE
            holder.categoryTV.text = currentCategory.catName
            holder.totalAssigned.text = currentCategory.catAssignedMoney.toString()
            holder.totalAvailable.text = currentCategory.catAvailableMoney.toString()
        }
        else {
            holder.categoryConstraint.visibility = View.GONE
            holder.subcategoryTV.text = currentCategory.catName
            holder.subAssigned.text = currentCategory.catAssignedMoney.toString()
            holder.subAvailable.text = currentCategory.catAvailableMoney.toString()
        }

    }

    override fun getItemCount(): Int {
        return allCategories.size
    }


}