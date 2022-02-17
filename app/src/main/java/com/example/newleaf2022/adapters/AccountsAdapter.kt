package com.example.newleaf2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.R
import com.example.newleaf2022.dataclasses.Accounts

class AccountsAdapter(private val accounts: ArrayList<Accounts>) : RecyclerView.Adapter<AccountsAdapter.AccountsViewHolder>() {

    class AccountsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val accountName: TextView = itemView.findViewById(R.id.accountName)
        val accountBalance: TextView = itemView.findViewById(R.id.outputBalance)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_accounts, parent, false)
        return AccountsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountsViewHolder, position: Int) {

        if (accounts[0].name.contentEquals("NULL!")) {
            holder.accountName.text = null
            holder.accountBalance.text = null
        }
        else {
            holder.accountName.text = accounts[position].name
            holder.accountBalance.text = accounts[position].balance.toString()
        }

    }

    override fun getItemCount(): Int {

        return if (accounts.isNullOrEmpty()) {
            0
        } else {
            accounts.size
        }
    }
}