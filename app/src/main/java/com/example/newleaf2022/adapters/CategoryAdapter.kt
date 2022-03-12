package com.example.newleaf2022.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class CategoryAdapter(private var allCategories: ArrayList<Categories>, private val categoryPositions: ArrayList<Int>, private val budgetsVM: BudgetsViewModel, private val readyToAssignTV: TextView) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    @SuppressLint("LongLogTag")
    class BudgetsViewHolder(ItemView: View, budgetsVM: BudgetsViewModel, allCategories: ArrayList<Categories>, unassignedTV: TextView, adapter: CategoryAdapter) : RecyclerView.ViewHolder(ItemView) {

        var initState = true
        val categoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Category)
        val categoryTV: TextView = itemView.findViewById(R.id.tv_Category)
        val totalAssigned: TextView = itemView.findViewById(R.id.tv_Assigned)
        val totalAvailable: TextView = itemView.findViewById(R.id.tv_Available)

        val subcategoryConstraint: LinearLayout = itemView.findViewById(R.id.cnst_Subcategory)
        val subcategoryTV: TextView = itemView.findViewById(R.id.tv_Subcategory)
        val subAssigned: EditText = itemView.findViewById(R.id.et_SubAssigned)
        val subAvailable: EditText = itemView.findViewById(R.id.et_SubAvailable)

        init {
            // Populating current viewholder's views using data from Model
            subAssigned.doAfterTextChanged {
                if (!initState) {
                    // Getting the user's input
                    val newAssignedValue =
                        if (subAssigned.text.isNullOrEmpty()) { 0.00 }
                        else { subAssigned.text.toString().toDouble() }



                    // Getting the index ( allCategories[] ) of the category this subcategory falls under
                    var targetCategoryIndex = 0
                    for (i in bindingAdapterPosition downTo 0) {
                        if (allCategories[i].getCategoryType()) {
                            targetCategoryIndex = i
                            break
                        }
                    }
                    Log.d("CategoryAdapter.BudgetsViewHolder.init", "targetCategory: ${allCategories[targetCategoryIndex]}")
                    Log.d("CategoryAdapter.BudgetsViewHolder.init", "targetSubcategory: ${allCategories[bindingAdapterPosition]}")

                    // Getting a list of related values after recalculating based on the newAssignedValue
                    val newValues = budgetsVM.editSubassigned(newAssignedValue, allCategories[targetCategoryIndex], allCategories[bindingAdapterPosition])
                    Log.d("CategoryAdapter.BudgetsViewHolder.init", "New Values { Unassigned: ${unassignedTV.text}, Sub Assigned: ${allCategories[bindingAdapterPosition].getAssigned()}, Sub Available: ${allCategories[bindingAdapterPosition].getAvailable()}, Category Assigned: ${allCategories[targetCategoryIndex].getAssigned()}, Category Available: ${allCategories[targetCategoryIndex].getAvailable()} }")

                    // Updating allCategories with the newValues
                    allCategories[bindingAdapterPosition].setAvailable(newValues[2])
                    allCategories[targetCategoryIndex].setAssigned(newValues[3])
                    allCategories[targetCategoryIndex].setAvailable(newValues[4])

                    // Updating relevant views
                    subAvailable.setText(newValues[1].toString()) 
                    adapter.notifyItemChanged(targetCategoryIndex)
                    unassignedTV.text = newValues[0].toString()

                    // This outputs the values of the recently changed categories and subcategories

                }
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)

        return BudgetsViewHolder(
            view,
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