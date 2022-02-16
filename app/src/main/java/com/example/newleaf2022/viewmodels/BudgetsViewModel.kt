package com.example.newleaf2022.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BudgetsViewModel : ViewModel() {

    val currentBudget: MutableLiveData<Budgets> by lazy { MutableLiveData<Budgets>()}
    val currentCategories: MutableLiveData<ArrayList<Categories>> by lazy { MutableLiveData<ArrayList<Categories>>()}
    val currentAccounts: MutableLiveData<ArrayList<Accounts>> by lazy { MutableLiveData<ArrayList<Accounts>>()}


}