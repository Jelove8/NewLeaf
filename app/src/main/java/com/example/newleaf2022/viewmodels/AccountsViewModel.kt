package com.example.newleaf2022.viewmodels

import android.accounts.Account
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newleaf2022.MainActivity

class AccountsViewModel : ViewModel() {

     val accounts: MutableLiveData<ArrayList<Accounts>> by lazy { MutableLiveData<ArrayList<Accounts>>() }

    fun addAccount(newAccount: Accounts, mainActivity: MainActivity) {
       mainActivity.model.addAccount(newAccount)
    }



}