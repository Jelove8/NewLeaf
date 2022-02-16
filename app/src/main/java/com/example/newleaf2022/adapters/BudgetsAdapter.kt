package com.example.newleaf2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R

class BudgetsAdapter() : RecyclerView.Adapter<BudgetsAdapter.BudgetsViewHolder>() {

    class BudgetsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val mainCategory: TextView = itemView.findViewById(R.id.mainCategoryTV)
        val totalAssigned: EditText = itemView.findViewById(R.id.outputTotalAssigned)
        val totalAvailable: EditText = itemView.findViewById(R.id.outputTotalAvailable)
        val subCategory: TextView = itemView.findViewById(R.id.subCategoryTV)
        val subAssigned: EditText = itemView.findViewById(R.id.inputAssigned)
        val subAvailable: EditText = itemView.findViewById(R.id.outputAvailable)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_budgets, parent, false)
        return BudgetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {

        holder.mainCategory.text = ""
        holder.totalAssigned.setText("")
        holder.totalAvailable.setText("")

        holder.subCategory.text = ""
        holder.subAssigned.setText("")
        holder.subAvailable.setText("")
    }

    override fun getItemCount(): Int {
        return 0
    }
    }