package com.example.newleaf2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.models.Transactions

class TransactionAdapter(private val transactions: ArrayList<Transactions>) : RecyclerView.Adapter<TransactionAdapter.TransactionsViewHolder>() {

    class TransactionsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val dateTV: TextView = itemView.findViewById(R.id.transactionDateTV)
        val dateConstraint: ConstraintLayout = itemView.findViewById(R.id.transactionDateConstraint)

        val transactionConstraint:ConstraintLayout = itemView.findViewById(R.id.transactionConstraint)
        val rButton: RadioButton = itemView.findViewById(R.id.rButton)
        val payeeTV: TextView = itemView.findViewById(R.id.payeeTV)
        val subTV: TextView = itemView.findViewById(R.id.subcategoryTV)
        val amountTV: TextView = itemView.findViewById(R.id.transactionAmountTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_transactions, parent, false)
        return TransactionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {



    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}