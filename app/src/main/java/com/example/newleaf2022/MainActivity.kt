package com.example.newleaf2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    fun changeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction
            .replace(R.id.mainFragment, fragment)
            .addToBackStack(null)
            .commit()
    }

    val newButton: Button = findViewById(R.id.miscButton1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun setMainUI(display: String) {
            when (display) {
                "Budgets" -> {
                    binding.headerTV.text = "feb2022"
                    binding.miscButton1.visibility = View.INVISIBLE
                    binding.miscButton2.visibility = View.VISIBLE
                    binding.mainConstraint3.visibility = View.VISIBLE
                    changeFragment(BudgetsFragment())
                }
                "Accounts" -> {
                    binding.headerTV.text = "Accounts"
                    binding.miscButton1.visibility = View.INVISIBLE
                    binding.miscButton2.visibility = View.VISIBLE
                    binding.mainConstraint3.visibility = View.VISIBLE
                    changeFragment(AccountsFragment())
                }
                "Add Transaction" -> {
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction
                        .replace(R.id.subFragment, NewTransactionFragment())
                        .addToBackStack(null)
                        .commit()
                }
                else -> {}
            }
        }



        binding.miscButton1.setOnClickListener {

        }
        binding.miscButton2.setOnClickListener {

        }

        binding.mainButton1.setOnClickListener {
            setMainUI("Budgets")
        }

        binding.mainButton2.setOnClickListener {
            setMainUI("Accounts")
        }
    }
}