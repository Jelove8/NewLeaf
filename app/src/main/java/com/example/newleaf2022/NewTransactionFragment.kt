package com.example.newleaf2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.newleaf2022.databinding.FragmentNewTransactionBinding
import com.example.newleaf2022.models.dataclasses.Transactions
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class NewTransactionFragment : Fragment() {

    private var fragmentBinding: FragmentNewTransactionBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentNewTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = context as MainActivity
        val budgetsVM: BudgetsViewModel by activityViewModels()


        var signCheck = false
        var clearedCheck = false

        binding.btnCancelTransaction.setOnClickListener {
            mainActivity.changeFragment("remove", this)
        }

        binding.btnChangeSign.setOnClickListener {
            signCheck = !signCheck
        }

        binding.btnCleared.setOnClickListener {
            clearedCheck = !clearedCheck
        }

        binding.btnAddTransaction.setOnClickListener {
            var amount = 0.00
            amount = if (signCheck) {
                binding.inputAmount.text.toString().toDouble()
            }
            else {
                ("-${binding.inputAmount.text}").toDouble()
            }

            var payee = binding.inputPayee.text.toString()
            var subcategory = binding.inputSubcategory1.toString()
            var account = binding.inputAccount.text.toString()
            var cleared = clearedCheck
            var memo = binding.inputMemo.text.toString()

            val newTransaction = Transactions(amount, payee, subcategory, cleared, memo)

            for (item in budgetsVM.getCurrentBudget().getAccounts()) {

                if (account == item.getName()) {
                    item.getTransactions().add(newTransaction)
                }


            }


        }


    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}