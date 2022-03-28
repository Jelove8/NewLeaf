package com.example.newleaf2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2022.databinding.ActivityMainBinding
import com.example.newleaf2022.models.Model
import com.example.newleaf2022.viewmodels.BudgetsViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var model: Model
    private lateinit var budgetsVM: BudgetsViewModel
    private lateinit var numpad: FragmentContainerView

    fun changeFragment(container: String, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (container) {
            "main" -> {
                fragmentTransaction
                    .replace(R.id.frag_main, fragment)
                    .addToBackStack(null)
                    .commit()
            }
            "numpad" -> {
                numpad.visibility = View.VISIBLE
                fragmentTransaction
                    .replace(R.id.frag_numpad, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    fun hideNumpad() {
        numpad.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = Model()
        numpad = binding.fragNumpad
        budgetsVM  = ViewModelProvider(this)[BudgetsViewModel::class.java]
        budgetsVM.initializeUser(model)


        budgetsVM.setCurrentDate(Calendar.getInstance())


        // Button: Display monthly budget categories
        binding.btnNavbar1.setOnClickListener {
            changeFragment("main", BudgetFragment())
        }

        // Button: Display User Accounts
        binding.btnNavbar2.setOnClickListener {
            changeFragment("main", AccountsFragment())
        }

        // Button: Display "Add New Transaction" Page
        binding.btnNavbar3.setOnClickListener {
            changeFragment("main", NewTransactionFragment())
        }

        binding.btnNavbar4.setOnClickListener {

        }

        binding.btnNavbar5.setOnClickListener {

        }
    }
}