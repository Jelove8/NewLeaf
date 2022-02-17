package com.example.newleaf2022.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newleaf2022.MainActivity
import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.dataclasses.Budgets
import com.example.newleaf2022.dataclasses.Categories
import com.example.newleaf2022.dataclasses.Subcategories

class BudgetsViewModel : ViewModel() {

    val currentCategories: MutableLiveData<ArrayList<Categories>> by lazy { MutableLiveData<ArrayList<Categories>>()}
    val assignedValues: MutableLiveData<ArrayList<Double>> by lazy { MutableLiveData<ArrayList<Double>>()}

    fun addNewAccount(newAccount: Accounts, mainActivity: MainActivity) {
        mainActivity.model.addAccount(newAccount)
    }

    fun getAccounts(mainActivity: MainActivity): ArrayList<Accounts>? {
        return mainActivity.model.getCurrentBudget()?.accounts
    }

    fun initializeBudget(mainActivity: MainActivity) {
        mainActivity.model.initializeModel()
    }

    fun getBudget(mainActivity: MainActivity): Budgets? {
        return mainActivity.model.getCurrentBudget()
    }

    fun updateCategories(categories: ArrayList<Categories>, mainActivity: MainActivity) {
        mainActivity.model.changeCategories(categories)
    }


}