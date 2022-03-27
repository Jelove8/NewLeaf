package com.example.newleaf2022.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.MainActivity
import com.example.newleaf2022.NumpadFragment
import com.example.newleaf2022.R
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class CategoryAdapter(private var allCategories: ArrayList<Categories>, private val mainActivity: MainActivity, private val categoryPositions: ArrayList<Int>, private val budgetsVM: BudgetsViewModel, private val readyToAssignTV: TextView) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    @SuppressLint("LongLogTag")
    class BudgetsViewHolder(ItemView: View, mainActivity: MainActivity, budgetsVM: BudgetsViewModel, allCategories: ArrayList<Categories>, unassignedTV: TextView, adapter: CategoryAdapter) : RecyclerView.ViewHolder(ItemView) {

        var initState = true
        val categoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Category)
        val categoryTV: TextView = itemView.findViewById(R.id.tv_Category)
        val totalAssigned: TextView = itemView.findViewById(R.id.tv_Assigned)
        val totalAvailable: TextView = itemView.findViewById(R.id.tv_Available)

        val subcategoryConstraint: LinearLayout = itemView.findViewById(R.id.cnst_Subcategory)
        val subcategoryTV: TextView = itemView.findViewById(R.id.tv_Subcategory)
        val subAssigned: TextView = itemView.findViewById(R.id.tv_SubAssigned)
        val subAvailable: TextView = itemView.findViewById(R.id.tv_SubAvailable)

        init {
            subAssigned.setOnClickListener {
                mainActivity.changeFragment("numpad", NumpadFragment())
            }
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
            readyToAssignTV,
            this
        )
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {
        val currentItem = allCategories[position]

        // Populating unassigned, category, and subcategory views
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
            holder.subAssigned.setText(currentItem.getAssigned().toString())
            holder.subAvailable.setText(currentItem.getAvailable().toString())
        }

        // The doAfterTextChange() of BudgetsViewHolder is now functional
        holder.initState = false

    }

    override fun getItemCount(): Int {
        return allCategories.size
    }


}