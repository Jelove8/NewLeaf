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
import com.example.newleaf2022.viewmodels.Subcategories

class SubcategoryAdapter(private val subcategories: ArrayList<Subcategories>) : RecyclerView.Adapter<SubcategoryAdapter.SubcategoryViewHolder>() {

    var check = 0
    class SubcategoryViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val constraint: ConstraintLayout = itemView.findViewById(R.id.subCategoryConstraint)
        val subCategory: TextView = itemView.findViewById(R.id.subCategoryTV)
        val assigned: EditText = itemView.findViewById(R.id.inputAssigned)
        val available: EditText = itemView.findViewById(R.id.outputAvailable)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_subcategories, parent, false)
        return SubcategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {

        if (subcategories[0].name.contentEquals("NULL!")) {
            holder.constraint.visibility = View.GONE
        }
        else {
            holder.subCategory.text = subcategories[position].name
            Log.d("Meowth", "Check: $check, Subcategory: ${subcategories[position].name}")
            check++
        }


    }

    override fun getItemCount(): Int {
        return subcategories.size
    }
}