package com.example.newleaf2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.models.Categories

class EditCategoriesAdapter(private val categories: ArrayList<Categories>) : RecyclerView.Adapter<EditCategoriesAdapter.EditCategoriesViewHolder>() {

    class EditCategoriesViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val btnDeleteCategory: Button = itemView.findViewById(R.id.btnDeleteCategory)
        val btnAddSubCategory: Button = itemView.findViewById(R.id.btnAddSubCategory)
        val inputCategory: EditText = itemView.findViewById(R.id.inputCategory)
        val recycler: RecyclerView = itemView.findViewById(R.id.vhEditBudgetsRecycler)
    }

    private fun removeCategory(position: Int) {
        categories.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditCategoriesAdapter.EditCategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)
        return EditCategoriesAdapter.EditCategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: EditCategoriesAdapter.EditCategoriesViewHolder, position: Int) {

        if (categories[position].name.isNullOrEmpty()) {
            holder.inputCategory.visibility = View.GONE
            holder.btnDeleteCategory.visibility = View.GONE
            holder.btnAddSubCategory.visibility = View.GONE
            holder.recycler.visibility = View.GONE
        }
        else {
            holder.inputCategory.setText(categories[position].name)
            holder.btnDeleteCategory.setOnClickListener {
                removeCategory(position)
            }

        }




    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
