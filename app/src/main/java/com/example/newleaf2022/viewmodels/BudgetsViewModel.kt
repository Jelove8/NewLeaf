package com.example.newleaf2022.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newleaf2022.MainActivity
import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.dataclasses.Budgets
import com.example.newleaf2022.dataclasses.Categories

class BudgetsViewModel : ViewModel() {

    val currentBudget: MutableLiveData<Budgets> by lazy { MutableLiveData<Budgets>()}
    val currentCategories: MutableLiveData<ArrayList<Categories>> by lazy { MutableLiveData<ArrayList<Categories>>()}

    fun addNewAccount(newAccount: Accounts, mainActivity: MainActivity) {
        mainActivity.model.addAccount(newAccount)
    }

    fun getAccounts(mainActivity: MainActivity): ArrayList<Accounts> {
        return mainActivity.model.getCurrentBudget().accounts
    }

}