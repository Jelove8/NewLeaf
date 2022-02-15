package com.example.newleaf2022.viewmodels

import android.accounts.Account
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountsViewModel : ViewModel() {

    private val accounts: MutableLiveData<ArrayList<Class<Account>>> by lazy { MutableLiveData<ArrayList<Class<Account>>>() }

    fun addAccount(newAccount: Class<Account>) {
        accounts.value!!.add(newAccount)
    }
}