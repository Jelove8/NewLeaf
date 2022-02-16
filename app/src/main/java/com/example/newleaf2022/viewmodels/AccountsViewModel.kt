package com.example.newleaf2022.viewmodels

import android.accounts.Account
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountsViewModel : ViewModel() {

     val accounts: MutableLiveData<ArrayList<Accounts>> by lazy { MutableLiveData<ArrayList<Accounts>>() }

    fun addAccount(newAccount: Accounts) {
        if (accounts.value.isNullOrEmpty()) {
            accounts.value = arrayListOf()
        }
        accounts.value!!.add(newAccount)
    }



}