package com.example.newleaf2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.adapters.CategoryAdapter
import com.example.newleaf2022.databinding.FragmentBudgetBinding
import com.example.newleaf2022.models.dataclasses.Categories
import com.example.newleaf2022.viewmodels.BudgetsViewModel

import java.util.*

class BudgetFragment : Fragment() {

    private var fragmentBinding: FragmentBudgetBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentBudgetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragBudgetsRecycler.layoutManager = LinearLayoutManager(activity)
        val mainActivity = (context as MainActivity)
        val budgetsVM: BudgetsViewModel by activityViewModels()

        // Displaying unassigned amount
        binding.outputTotalUnassigned.text = budgetsVM.getCurrentBudget().getUnassigned().toString()


        // Populating the recycler view



        fun populateCategoriesRecyclerView() {
            val newAdapter = CategoryAdapter(budgetsVM.getAllCategories(), mainActivity, budgetsVM.getCategoryPositions(), budgetsVM, binding.outputTotalUnassigned)
            binding.fragBudgetsRecycler.adapter = newAdapter
        }

        populateCategoriesRecyclerView()



        // Populating RecyclerView

        binding.btnMisc1.setOnClickListener {
            binding.cnstDateButtonsPerimeter.visibility = View.GONE
        }

        binding.btnChangeDate.setOnClickListener {
            if (binding.cnstDateButtonsPerimeter.visibility == View.GONE) {
                var lockUpTo = 0
                for (yearlyBudget in budgetsVM.getCurrentBudget().getYearlyBudgets()) {
                    if (yearlyBudget.getYear() == budgetsVM.getCurrentYear()) {
                        lockUpTo = yearlyBudget.getMonthlyBudgets().size - 1
                    }
                }
                for ((b,button) in binding.cnstDateButtons.children.withIndex()) {
                    if (b > lockUpTo) {
                        val btn = button as Button
                        btn.isClickable = false
                        btn.text = "X"
                    }
                }
                binding.cnstDateButtonsPerimeter.visibility = View.VISIBLE
            }
            else {
                binding.cnstDateButtonsPerimeter.visibility = View.GONE
            }
        }

        binding.btnEditBudget.setOnClickListener {
            binding.cnstDateButtonsPerimeter.visibility = View.GONE
            mainActivity.changeFragment("main", EditCategoriesFragment())
        }

        // Hides "Date Buttons" if they are currently visible
        binding.tvDateButtonsWhiteSpace.setOnClickListener {
            binding.cnstDateButtonsPerimeter.visibility = View.GONE
        }


        // Date Button Logic
        binding.btnJan.setOnClickListener{
            budgetsVM.setCurrentDate("custom", mutableListOf(0))
        }
        for (button in binding.cnstDateButtons.children) {
            if (button.isClickable) {
                button.setOnClickListener {
                    when ((button as Button).text) {
                        "Jan" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(0))
                        }
                        "Feb" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(1))
                        }
                        "Mar" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(2))
                        }
                        "Apr" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(3))
                        }
                        "May" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(4))
                        }
                        "Jun" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(5))
                        }
                        "Jul" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(6))
                        }
                        "Aug" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(7))
                        }
                        "Sep" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(8))
                        }
                        "Oct" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(9))
                        }
                        "Nov" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(10))
                        }
                        "Dec" -> {
                            budgetsVM.setCurrentDate("custom", mutableListOf(11))
                        }
                    }
                    populateCategoriesRecyclerView()
                    binding.cnstDateButtonsPerimeter.visibility = View.GONE
                }
            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}