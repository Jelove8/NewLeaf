package com.example.newleaf2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2022.databinding.ActivityMainBinding
import com.example.newleaf2022.models.Model
import com.example.newleaf2022.viewmodels.AccountsViewModel
import com.example.newleaf2022.viewmodels.Budgets
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class MainActivity : AppCompatActivity() {

    fun changeFragment(container: String, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (container) {
            "main" -> {
                fragmentTransaction
                    .replace(R.id.mainFragment, fragment)
                    .addToBackStack(null)
                    .commit()
            }
            "sub" -> {
                fragmentTransaction
                    .replace(R.id.subFragment, fragment)
                    .addToBackStack(null)
                    .commit()
            }
            else -> {
                fragmentTransaction
                    .remove(fragment)
                    .commit()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val model = Model()
        val budgetsVM = ViewModelProvider(this)[BudgetsViewModel::class.java]
        setContentView(binding.root)


        // Initializing Data
        model.initializeModel()
        budgetsVM.currentBudget.value = model.getCurrentBudget()
        budgetsVM.currentAccounts.value = model.getCurrentAccounts()
        budgetsVM.currentCategories.value = model.getCurrentCategories()


        // Main Button Logic
        binding.mainButton1.setOnClickListener {
            changeFragment("main", BudgetsFragment())
        }

        binding.mainButton2.setOnClickListener {
            changeFragment("main", AccountsFragment())
        }

        binding.mainButton3.setOnClickListener {
            binding.subFragment.visibility = View.VISIBLE
            changeFragment("sub", NewTransactionFragment())
        }

        binding.mainButton4.setOnClickListener {

        }

        binding.mainButton5.setOnClickListener {

        }
    }
}