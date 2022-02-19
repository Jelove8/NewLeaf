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
import com.example.newleaf2022.MainActivity
import com.example.newleaf2022.R
import com.example.newleaf2022.models.Categories
import com.example.newleaf2022.models.Model
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class CategoryAdapter(private val categories: ArrayList<Categories>, private val budgetsVM: BudgetsViewModel, private val model: Model, private val readyToAssignTV: TextView) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    class BudgetsViewHolder(ItemView: View, listener: OnTextChangedListener, budgetsVM: BudgetsViewModel, categories: ArrayList<Categories>, model: Model, readyToAssignTV: TextView) : RecyclerView.ViewHolder(ItemView) {
        val mainCategory: TextView = itemView.findViewById(R.id.mainCategoryTV)
        val categoriesConstraint: ConstraintLayout = itemView.findViewById(R.id.categoriesConstraint)
        val subcategoriesConstraint: LinearLayout = itemView.findViewById(R.id.subcategoriesLinearLayout)

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

        val totalAssigned: TextView = itemView.findViewById(R.id.outputTotalAssigned)
        val totalAvailable: TextView = itemView.findViewById(R.id.outputTotalAvailable)

        val assigned1: EditText = itemView.findViewById(R.id.assigned1)
        val assigned2: EditText = itemView.findViewById(R.id.assigned2)
        val assigned3: EditText = itemView.findViewById(R.id.assigned3)
        val assigned4: EditText = itemView.findViewById(R.id.assigned4)
        val assigned5: EditText = itemView.findViewById(R.id.assigned5)
        val assigned6: EditText = itemView.findViewById(R.id.assigned6)
        val assigned7: EditText = itemView.findViewById(R.id.assigned7)
        val assigned8: EditText = itemView.findViewById(R.id.assigned8)
        val assigned9: EditText = itemView.findViewById(R.id.assigned9)
        val assigned10: EditText = itemView.findViewById(R.id.assigned10)
        val assigned11: EditText = itemView.findViewById(R.id.assigned11)
        val assigned12: EditText = itemView.findViewById(R.id.assigned12)
        val assigned13: EditText = itemView.findViewById(R.id.assigned13)
        val assigned14: EditText = itemView.findViewById(R.id.assigned14)
        val assigned15: EditText = itemView.findViewById(R.id.assigned15)
        val assigned16: EditText = itemView.findViewById(R.id.assigned16)

        val available1: EditText = itemView.findViewById(R.id.available1)
        val available2: EditText = itemView.findViewById(R.id.available2)
        val available3: EditText = itemView.findViewById(R.id.available3)
        val available4: EditText = itemView.findViewById(R.id.available4)
        val available5: EditText = itemView.findViewById(R.id.available5)
        val available6: EditText = itemView.findViewById(R.id.available6)
        val available7: EditText = itemView.findViewById(R.id.available7)
        val available8: EditText = itemView.findViewById(R.id.available8)
        val available9: EditText = itemView.findViewById(R.id.available9)
        val available10: EditText = itemView.findViewById(R.id.available10)
        val available11: EditText = itemView.findViewById(R.id.available11)
        val available12: EditText = itemView.findViewById(R.id.available12)
        val available13: EditText = itemView.findViewById(R.id.available13)
        val available14: EditText = itemView.findViewById(R.id.available14)
        val available15: EditText = itemView.findViewById(R.id.available15)
        val available16: EditText = itemView.findViewById(R.id.available16)

        private val listOfAssigned = arrayListOf(assigned1, assigned2, assigned3, assigned4, assigned5, assigned6, assigned7, assigned8, assigned9, assigned10, assigned11, assigned12, assigned13, assigned14, assigned15, assigned16)
        private val listOfAvailable = arrayListOf(available1, available2, available3, available4, available5, available6, available7, available8, available9, available10, available11, available12, available13, available14, available15, available16)

        init {

            for ((i, item) in listOfAssigned.withIndex()) {
                item.doAfterTextChanged {
                    listener.onTextChanged(bindingAdapterPosition)
                    val currentCategory = categories[bindingAdapterPosition]
                    val oldAssigned = currentCategory.subcategories[i].assigned
                
                    if (item.text.isNullOrEmpty()) {
                        // Updating currentCategory
                        currentCategory.subcategories[i].assigned = 0.00
                        currentCategory.subcategories[i].available -= oldAssigned
                        currentCategory.totalAssigned -= oldAssigned
                        currentCategory.totalAvailable -= oldAssigned
                        // Updating views
                        listOfAvailable[i].setText(currentCategory.subcategories[i].available.toString())
                        totalAssigned.text = currentCategory.totalAssigned.toString()
                        totalAvailable.text = currentCategory.totalAvailable.toString()
                        readyToAssignTV.text = budgetsVM.getCurrentBudget().unassigned.toString()
                        // Updating viewmodel and model
                        budgetsVM.updateCategory(currentCategory, bindingAdapterPosition, model)
                    }
                    else {
                        // Updating currentCategory
                        val newAssigned = item.text.toString().toDouble()
                        currentCategory.subcategories[i].assigned = newAssigned
                        currentCategory.subcategories[i].available = currentCategory.subcategories[i].available - oldAssigned + newAssigned
                        currentCategory.totalAssigned = currentCategory.totalAssigned - oldAssigned + newAssigned
                        currentCategory.totalAvailable = currentCategory.totalAvailable - oldAssigned + newAssigned
                        // Updating views
                        listOfAvailable[i].setText(currentCategory.subcategories[i].available.toString())
                        totalAssigned.text = currentCategory.totalAssigned.toString()
                        totalAvailable.text = currentCategory.totalAvailable.toString()
                        readyToAssignTV.text = budgetsVM.getCurrentBudget().unassigned.toString()
                        // Updating viewmodel and model
                        budgetsVM.updateCategory(currentCategory, bindingAdapterPosition, model)
                    }
                }
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)

        return BudgetsViewHolder(view, textChangeListener, budgetsVM, categories, model, readyToAssignTV)
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {

        val categorySize = categories.size
        val currentCategory = categories[position]
        val subcategoryViews = arrayListOf(holder.subcategory1, holder.subcategory2, holder.subcategory3, holder.subcategory4, holder.subcategory5, holder.subcategory6, holder.subcategory7, holder.subcategory8, holder.subcategory9, holder.subcategory10, holder.subcategory11, holder.subcategory12, holder.subcategory13, holder.subcategory14, holder.subcategory15, holder.subcategory16)
        val subcategoryNameViews = arrayListOf(holder.sub1, holder.sub2, holder.sub3, holder.sub4, holder.sub5, holder.sub6, holder.sub7, holder.sub8, holder.sub9, holder.sub10, holder.sub11, holder.sub12, holder.sub13, holder.sub14, holder.sub15, holder.sub16)
        val subcategoryAssignedViews = arrayListOf(holder.assigned1, holder.assigned2, holder.assigned3, holder.assigned4, holder.assigned5, holder.assigned6, holder.assigned7, holder.assigned8, holder.assigned9, holder.assigned10, holder.assigned11, holder.assigned12, holder.assigned13, holder.assigned14, holder.assigned15, holder.assigned16)
        val subcategoryAvailableViews = arrayListOf(holder.available1, holder.available2, holder.available3, holder.available4, holder.available5, holder.available6, holder.available7, holder.available8, holder.available9, holder.available10, holder.available11, holder.available12, holder.available13, holder.available14, holder.available15, holder.available16)

        // Setting up initial display
        when {
            categorySize == 0 -> {
                // Hides entire viewholder
                holder.categoriesConstraint.visibility = View.GONE
                holder.subcategoriesConstraint.visibility = View.GONE
            }
            currentCategory.subcategories.size == 0 -> {
                // Hides only the subcategory views
                holder.mainCategory.text = currentCategory.name
                holder.totalAssigned.text = currentCategory.totalAssigned.toString()
                holder.totalAvailable.text = currentCategory.totalAvailable.toString()
                holder.subcategoriesConstraint.visibility = View.GONE
            }
            else -> {
                // Displays and populates all necessary views
                holder.mainCategory.text = currentCategory.name
                holder.totalAssigned.text = currentCategory.totalAssigned.toString()
                holder.totalAvailable.text = currentCategory.totalAvailable.toString()
                for (i in 0 until currentCategory.subcategories.size) {
                    val currentSubcategory = currentCategory.subcategories[i]
                    subcategoryNameViews[i].text = currentSubcategory.name
                    subcategoryAssignedViews[i].setText(currentSubcategory.assigned.toString())
                    subcategoryAvailableViews[i].setText(currentSubcategory.available.toString())
                    subcategoryViews[i].visibility = View.VISIBLE
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}