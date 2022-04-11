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

class AccountsAdapter(private val accounts: MutableList<Accounts>, private val mainActivity: MainActivity) : RecyclerView.Adapter<AccountsAdapter.AccountsViewHolder>() {

    class AccountsViewHolder(ItemView: View, mainActivity: MainActivity, accounts: MutableList<Accounts>) : RecyclerView.ViewHolder(ItemView) {
        private val tvAcctName: TextView = itemView.findViewById(R.id.tv_acctName)
        private val tvAcctBalance: TextView = itemView.findViewById(R.id.tv_acctBalance)
        private val cnstAccountVH: ConstraintLayout = itemView.findViewById(R.id.cnst_acctViewholder)

        init {

            // Populating viewholder items
            if (accounts.isEmpty()) {
                tvAcctName.text = mainActivity.getString(R.string.add_a_new_account_to_start_budgeting)
                tvAcctBalance.visibility = View.INVISIBLE
                cnstAccountVH.isClickable = false
            }
            else {
                tvAcctName.text = accounts[bindingAdapterPosition].acctName
                tvAcctBalance.text = accounts[bindingAdapterPosition].acctBalance.toString()
                cnstAccountVH.isClickable = true
            }

            // Go to --> TransactionsFragment()
            cnstAccountVH.setOnClickListener {
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



    }

    override fun getItemCount(): Int {
        return accounts.size
    }
}