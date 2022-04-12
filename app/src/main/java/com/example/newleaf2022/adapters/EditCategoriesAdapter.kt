package com.example.newleaf2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.viewmodels.BudgetsViewModel
/*
class EditCategoriesAdapter(private val categories: ArrayList<Categories>, private val budgetsVM: BudgetsViewModel) : RecyclerView.Adapter<EditCategoriesAdapter.EditCategoriesViewHolder>() {

    class EditCategoriesViewHolder(ItemView: View, categories: ArrayList<Categories>, private val budgetsVM: BudgetsViewModel, private val adapter: EditCategoriesAdapter) : RecyclerView.ViewHolder(ItemView) {
        val categoryConstraint: ConstraintLayout = itemView.findViewById(R.id.cnst_Category)
        val btnDeleteCategory: Button = itemView.findViewById(R.id.btnDeleteCategory)
        val btnAddSubcategory: Button = itemView.findViewById(R.id.btnAddSubCategory)
        val inputCategory: EditText = itemView.findViewById(R.id.inputCategory)

        val sub1: EditText = itemView.findViewById(R.id.inputSubcategory1)
        val sub2: EditText = itemView.findViewById(R.id.inputSubcategory2)
        val sub3: EditText = itemView.findViewById(R.id.inputSubcategory3)
        val sub4: EditText = itemView.findViewById(R.id.inputSubcategory4)
        val sub5: EditText = itemView.findViewById(R.id.inputSubcategory5)
        val sub6: EditText = itemView.findViewById(R.id.inputSubcategory6)
        val sub7: EditText = itemView.findViewById(R.id.inputSubcategory7)
        val sub8: EditText = itemView.findViewById(R.id.inputSubcategory8)
        val sub9: EditText = itemView.findViewById(R.id.inputSubcategory9)
        val sub10: EditText = itemView.findViewById(R.id.inputSubcategory10)
        val sub11: EditText = itemView.findViewById(R.id.inputSubcategory11)
        val sub12: EditText = itemView.findViewById(R.id.inputSubcategory12)
        val sub13: EditText = itemView.findViewById(R.id.inputSubcategory13)
        val sub14: EditText = itemView.findViewById(R.id.inputSubcategory14)
        val sub15: EditText = itemView.findViewById(R.id.inputSubcategory15)
        val sub16: EditText = itemView.findViewById(R.id.inputSubcategory16)

        val subConstraint1: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint1)
        val subConstraint2: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint2)
        val subConstraint3: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint3)
        val subConstraint4: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint4)
        val subConstraint5: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint5)
        val subConstraint6: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint6)
        val subConstraint7: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint7)
        val subConstraint8: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint8)
        val subConstraint9: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint9)
        val subConstraint10: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint10)
        val subConstraint11: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint11)
        val subConstraint12: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint12)
        val subConstraint13: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint13)
        val subConstraint14: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint14)
        val subConstraint15: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint15)
        val subConstraint16: ConstraintLayout = itemView.findViewById(R.id.subcategoriesConstraint16)
        val subConstraints = arrayListOf(subConstraint1, subConstraint2, subConstraint3, subConstraint4, subConstraint5, subConstraint6, subConstraint7, subConstraint8, subConstraint9, subConstraint10, subConstraint11, subConstraint12, subConstraint13, subConstraint14, subConstraint15, subConstraint16)

        val btnDeleteSub1: Button = itemView.findViewById(R.id.btnDeleteSubcategory1)
        val btnDeleteSub2: Button = itemView.findViewById(R.id.btnDeleteSubcategory2)
        val btnDeleteSub3: Button = itemView.findViewById(R.id.btnDeleteSubcategory3)
        val btnDeleteSub4: Button = itemView.findViewById(R.id.btnDeleteSubcategory4)
        val btnDeleteSub5: Button = itemView.findViewById(R.id.btnDeleteSubcategory5)
        val btnDeleteSub6: Button = itemView.findViewById(R.id.btnDeleteSubcategory6)
        val btnDeleteSub7: Button = itemView.findViewById(R.id.btnDeleteSubcategory7)
        val btnDeleteSub8: Button = itemView.findViewById(R.id.btnDeleteSubcategory8)
        val btnDeleteSub9: Button = itemView.findViewById(R.id.btnDeleteSubcategory9)
        val btnDeleteSub10: Button = itemView.findViewById(R.id.btnDeleteSubcategory10)
        val btnDeleteSub11: Button = itemView.findViewById(R.id.btnDeleteSubcategory11)
        val btnDeleteSub12: Button = itemView.findViewById(R.id.btnDeleteSubcategory12)
        val btnDeleteSub13: Button = itemView.findViewById(R.id.btnDeleteSubcategory13)
        val btnDeleteSub14: Button = itemView.findViewById(R.id.btnDeleteSubcategory14)
        val btnDeleteSub15: Button = itemView.findViewById(R.id.btnDeleteSubcategory15)
        val btnDeleteSub16: Button = itemView.findViewById(R.id.btnDeleteSubcategory16)
        val deleteSubcategoryButtons = arrayListOf(btnDeleteSub1, btnDeleteSub2, btnDeleteSub3, btnDeleteSub4, btnDeleteSub5, btnDeleteSub6, btnDeleteSub7, btnDeleteSub8, btnDeleteSub9, btnDeleteSub10, btnDeleteSub11, btnDeleteSub12, btnDeleteSub13, btnDeleteSub14, btnDeleteSub15, btnDeleteSub16)


        val listOfSubs = arrayListOf(sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10, sub11, sub12, sub13, sub14, sub15, sub16)

        init {
            // User can change category name
            inputCategory.doAfterTextChanged {
                categories[bindingAdapterPosition].setName(inputCategory.text.toString())
            }

            btnDeleteCategory.setOnClickListener {
                categories.removeAt(bindingAdapterPosition)
                // Hides category views
                adapter.notifyDataSetChanged()
            }




            btnAddSubcategory.setOnClickListener {
                categories[bindingAdapterPosition].getSubcategories().add(0, Subcategories(name = ""))
                adapter.notifyDataSetChanged()
            }



            for ((i,item) in listOfSubs.withIndex()) {
                item.doAfterTextChanged {
                    categories[bindingAdapterPosition].getSubcategories()[i].setName(item.text.toString())
                }
            }

            for((i,item) in deleteSubcategoryButtons.withIndex()) {
                item.setOnClickListener {
                    categories[bindingAdapterPosition].getSubcategories().removeAt(i)
                    adapter.notifyItemChanged(bindingAdapterPosition)
                }
            }


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditCategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_edit_categories, parent, false)
        return EditCategoriesViewHolder(view, categories, budgetsVM, this)
    }

    override fun onBindViewHolder(holder: EditCategoriesViewHolder, position: Int) {
        when {
            categories.size == 0 -> {
                // Hides entire viewholder
                holder.categoryConstraint.visibility = View.GONE
                for (item in holder.subConstraints) {
                    item.visibility = View.GONE
                }
            }
            categories[position].getSubcategories().size == 0 -> {
                // Hides only the subcategory views
                holder.inputCategory.setText(categories[position].getName())
                for (item in holder.subConstraints) {
                    item.visibility = View.GONE
                }
            }
            else -> {
                // Displaying category views
                holder.inputCategory.setText(categories[position].getName())
                // Displaying subcategory views
                for (item in holder.subConstraints) {
                    item.visibility = View.GONE
                }
                for (i in 0 until categories[position].getSubcategories().size) {
                    val currentSubcategory = categories[position].getSubcategories()[i]
                    holder.subConstraints[i].visibility = View.VISIBLE
                    holder.listOfSubs[i].setText(currentSubcategory.getName())
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }


} */
