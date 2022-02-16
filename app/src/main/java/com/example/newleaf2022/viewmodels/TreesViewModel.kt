package com.example.newleaf2022.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TreesViewModel: ViewModel() {

    val currentTreeDisplayed: MutableLiveData<Trees> by lazy { MutableLiveData<Trees>() }
    val trees: MutableLiveData<ArrayList<Accounts>> by lazy { MutableLiveData<ArrayList<Accounts>>() }


}