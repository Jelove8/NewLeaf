package com.example.newleaf2022.adapters

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
import com.example.newleaf2022.models.Model
import com.example.newleaf2022.viewmodels.BudgetsViewModel
import org.w3c.dom.Text

class CategoryAdapter(private val categories: ArrayList<Categories>, private val budgetsVM: BudgetsViewModel, private val model: Model, private val readyToAssignTV: TextView) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    class BudgetsViewHolder(ItemView: View, listener: OnTextChangedListener, budgetsVM: BudgetsViewModel, categories: ArrayList<Categories>, model: Model, unassignedTV: TextView) : RecyclerView.ViewHolder(ItemView) {

        val categoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Category)
        val categoryTV: TextView = itemView.findViewById(R.id.tv_Category)
        val totalAssigned: TextView = itemView.findViewById(R.id.tv_Assigned)
        val totalAvailable: TextView = itemView.findViewById(R.id.tv_Available)

        val subcategoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Subcategory)
        val subcategoryTV: TextView = itemView.findViewById(R.id.tv_Subcategory)
        val subAssigned: EditText = itemView.findViewById(R.id.et_SubAssigned)
        val subAvailable: EditText = itemView.findViewById(R.id.et_SubAvailable)

        init {

           for ((i,item) in subAssignedValues.withIndex()) {

               // Text Changed Listeners for subAssigned
               item.doAfterTextChanged {
                   val oldSubAvailable = categories[bindingAdapterPosition].getSubcategories()[i].getAvailable()
                   val oldSubAssigned = categories[bindingAdapterPosition].getSubcategories()[i].getAssigned()

                   if (item.text.equals(null) || item.text.equals("")) {
                       val newUnassigned = budgetsVM.getCurrentBudget().getUnassigned() - oldSubAssigned

                       // Updating sub assigned value
                       categories[bindingAdapterPosition].getSubcategories()[i].setAssigned(0.00)

                       // Updating sub available value
                       categories[bindingAdapterPosition].getSubcategories()[i].setAvailable(oldSubAvailable - oldSubAssigned)
                       Log.d("Meow", "${ categories[bindingAdapterPosition].getSubcategories()[i].getAvailable()}")
                       subAvailableValues[i].setText(categories[bindingAdapterPosition].getSubcategories()[i].getAvailable().toString())

                       // Updating unassigned value
                       budgetsVM.getCurrentBudget().setUnassigned(newUnassigned)
                       unassignedTV.text = newUnassigned.toString()
                   }
                   else {
                       val newAssigned = item.text.toString().toDouble()
                       val newUnassigned = budgetsVM.getCurrentBudget().getUnassigned() - oldSubAssigned + newAssigned

                       // Updating sub assigned value
                       categories[bindingAdapterPosition].getSubcategories()[i].setAssigned(item.text.toString().toDouble())

                       // Updating sub available value
                       categories[bindingAdapterPosition].getSubcategories()[i].setAvailable(oldSubAvailable - oldSubAssigned + newAssigned)
                       subAvailableValues[i].setText(categories[bindingAdapterPosition].getSubcategories()[i].getAvailable().toString())

                       // Updating unassigned value
                       budgetsVM.getCurrentBudget().setUnassigned(newUnassigned)
                       unassignedTV.text = newUnassigned.toString()
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
            currentCategory.getSubcategories().size == 0 -> {
                // Hides only the subcategory views
                holder.mainCategory.text = currentCategory.getName()
                holder.totalAssigned.text = currentCategory.getAssigned().toString()
                holder.totalAvailable.text = currentCategory.getAvailable().toString()
                holder.subcategoriesConstraint.visibility = View.GONE
            }
            else -> {
                // Displays and populates all necessary views
                holder.mainCategory.text = currentCategory.getName()
                holder.totalAssigned.text = currentCategory.getAssigned().toString()
                holder.totalAvailable.text = currentCategory.getAvailable().toString()
                for (i in 0 until currentCategory.getSubcategories().size) {
                    val currentSubcategory = currentCategory.getSubcategories()[i]
                    subcategoryNameViews[i].text = currentSubcategory.getName()
                    subcategoryAssignedViews[i].setText(currentSubcategory.getAssigned().toString())
                    subcategoryAvailableViews[i].setText(currentSubcategory.getAvailable().toString())
                    subcategoryViews[i].visibility = View.VISIBLE
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}