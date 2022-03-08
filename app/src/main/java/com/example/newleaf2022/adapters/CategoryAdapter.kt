package com.example.newleaf2022.adapters

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

class CategoryAdapter(private val allCategories: ArrayList<Categories>, private val categoryPositions: ArrayList<Int>, private val budgetsVM: BudgetsViewModel, private val readyToAssignTV: TextView) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    class BudgetsViewHolder(ItemView: View, listener: OnTextChangedListener, categoryPositions: ArrayList<Int>, budgetsVM: BudgetsViewModel, allCategories: ArrayList<Categories>, unassignedTV: TextView, adapter: CategoryAdapter) : RecyclerView.ViewHolder(ItemView) {

        val categoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Category)
        val categoryTV: TextView = itemView.findViewById(R.id.tv_Category)
        val totalAssigned: TextView = itemView.findViewById(R.id.tv_Assigned)
        val totalAvailable: TextView = itemView.findViewById(R.id.tv_Available)

        val subcategoryConstraint: LinearLayout = itemView.findViewById(R.id.cnst_Subcategory)
        val subcategoryTV: TextView = itemView.findViewById(R.id.tv_Subcategory)
        val subAssigned: EditText = itemView.findViewById(R.id.et_SubAssigned)
        val subAvailable: EditText = itemView.findViewById(R.id.et_SubAvailable)

        init {
            var initialState = 0

            // Subcategory Assigned Value -- Text Changed Listener
            subAssigned.doAfterTextChanged {
                // Getting a list of strings

                if (initialState != 0) {
                        val newStrings =
                        if (subAssigned.text.isNullOrEmpty()) {
                            budgetsVM.editSubassigned(budgetsVM.getCurrentBudget().getUnassigned(),0.00, allCategories[bindingAdapterPosition])
                        }
                        else {
                            budgetsVM.editSubassigned(budgetsVM.getCurrentBudget().getUnassigned(),subAssigned.text.toString().toDouble(), allCategories[bindingAdapterPosition])
                        }
                    // newStrings[i]
                    // [0] = new unassigned value,
                    // [1] = new subAvailable value,
                    // [2] = new total assigned value,
                    // [3] new total available value

                    // Updating unassigned textview & subcategory's available textview
                    unassignedTV.text = newStrings[0]
                            subAvailable.setText(newStrings[1])

                        // A method to get the index of the previous category (aka, the category this subcategory falls under
                        val distancesFromCurrentPosition = arrayListOf<Int>()
                    for (item in categoryPositions) {
                        if ((bindingAdapterPosition - item) > 0) {
                            distancesFromCurrentPosition.add(bindingAdapterPosition - item)
                        }
                    }
                        val categoryIndex = distancesFromCurrentPosition.minByOrNull{ it }
                    // Updating the assigned & available textviews of the category
                    allCategories[categoryIndex!!].setAssigned(newStrings[2].toDouble())
                            allCategories[categoryIndex].setAvailable(newStrings[3].toDouble())
                            adapter.notifyItemChanged(categoryIndex)
                }
                initialState = 1
            }

        }
    }

    private lateinit var textChangeListener: OnTextChangedListener
    interface OnTextChangedListener {
        fun onTextChanged(position: Int)
    }
    fun setOnTextChangedListener(listener: OnTextChangedListener) {
        textChangeListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)

        return CategoryAdapter.BudgetsViewHolder(
            view,
            textChangeListener,
            categoryPositions,
            budgetsVM,
            allCategories,
            readyToAssignTV,
            this
        )
    }

    override fun onBindViewHolder(holder: CategoryAdapter.BudgetsViewHolder, position: Int) {

        val currentItem = allCategories[position]

        // If the current item is a category...
        if (currentItem.getCategoryType()) {
            holder.subcategoryConstraint.visibility = View.GONE
            holder.categoryTV.text = currentItem.getName()
            holder.totalAssigned.text = currentItem.getAssigned().toString()
            holder.totalAvailable.text = currentItem.getAvailable().toString()
        }
        // Else if the current item is a subcategory...
        else {
            holder.categoryConstraint.visibility = View.GONE
            holder.subcategoryTV.text = currentItem.getName()
            holder.subAssigned.setText(currentItem.getAssigned().toString())
            holder.subAvailable.setText(currentItem.getAvailable().toString())
        }

    }

    override fun getItemCount(): Int {
        return allCategories.size
    }
}