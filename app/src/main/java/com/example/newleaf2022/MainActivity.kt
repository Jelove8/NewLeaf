package com.example.newleaf2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2022.databinding.ActivityMainBinding
import com.example.newleaf2022.models.Model
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class MainActivity : AppCompatActivity() {

    lateinit var model: Model
    private lateinit var budgetsVM: BudgetsViewModel

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
        setContentView(binding.root)


        // Initializing Model & ViewModel
        model = Model()
        budgetsVM  = ViewModelProvider(this)[BudgetsViewModel::class.java]
        budgetsVM.initializeUser(model)


        // Main Button Logic
        binding.mainButton1.setOnClickListener {
            changeFragment("main", BudgetFragment())
            binding.subFragment.visibility = View.GONE
        }

        binding.mainButton2.setOnClickListener {
            changeFragment("main", AccountsFragment())
            binding.subFragment.visibility = View.GONE
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