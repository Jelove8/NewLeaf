package com.example.newleaf2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.MainActivity
import com.example.newleaf2022.R
import com.example.newleaf2022.TransactionsFragment
import com.example.newleaf2022.models.dataclasses.Accounts

class AccountsAdapter(private val accounts: ArrayList<Accounts>, private val mainActivity: MainActivity) : RecyclerView.Adapter<AccountsAdapter.AccountsViewHolder>() {

    class AccountsViewHolder(ItemView: View, mainActivity: MainActivity, accounts: ArrayList<Accounts>) : RecyclerView.ViewHolder(ItemView) {
        val accountName: TextView = itemView.findViewById(R.id.accountName)
        val accountBalance: TextView = itemView.findViewById(R.id.outputBalance)
        val accountConstraint: ConstraintLayout = itemView.findViewById(R.id.accountsVHConstraint)

        init {
            accountConstraint.setOnClickListener {
               mainActivity.changeFragment("main", TransactionsFragment(accounts[bindingAdapterPosition]))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_accounts, parent, false)
        return AccountsViewHolder(view, mainActivity, accounts)
    }

    override fun onBindViewHolder(holder: AccountsViewHolder, position: Int) {

        if (accounts[0].equals(null)) {
            holder.accountConstraint.visibility = View.GONE
        }
        else {
            holder.accountName.text = accounts[position].getName()
            holder.accountBalance.text = accounts[position].getBalance().toString()
        }

    }

    override fun getItemCount(): Int {
        return accounts.size
    }
}