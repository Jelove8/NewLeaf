package com.example.newleaf2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.adapters.CategoryAdapter
import com.example.newleaf2022.databinding.FragmentDisplayCategoriesBinding
import java.util.*


class DisplayCategoriesFragment : Fragment() {

    private lateinit var binding: FragmentDisplayCategoriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDisplayCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = (context as MainActivity)

        // Call to populate recycler view
        fun populateCategoriesRecyclerView() {
            val newAdapter = CategoryAdapter(mainActivity.getInstanceOfViewModel().getAllCategories(), mainActivity, binding.tvUnassignedValue)
            binding.rcyMonthlyCategories.layoutManager = LinearLayoutManager(activity)
            binding.rcyMonthlyCategories.adapter = newAdapter
        }

        // Displaying data
        binding.tvUnassignedValue.text = mainActivity.getInstanceOfViewModel().getCurrentBudget().bdgtUnassignedMoney.toString()
        populateCategoriesRecyclerView()


        binding.btnBdgtSelection.setOnClickListener {
            binding.cnstDateButtonsPerimeter.visibility = View.GONE
        }


        binding.btnBdgtEditCategories.setOnClickListener {
            binding.cnstDateButtonsPerimeter.visibility = View.GONE
            mainActivity.changeFragment("main", EditCategoriesFragment())
        }

        // Hides "Date Buttons" if they are currently visible
        binding.tvDateButtonsWhiteSpace.setOnClickListener {
            binding.cnstDateButtonsPerimeter.visibility = View.GONE
        }

        fun lockDateButtons(currentYearSelected: Int) {
            var activeBudgetsInSelectedYear = 0
            for (monthlyBdgt in mainActivity.getInstanceOfViewModel().getCurrentBudget().bdgtAllMonthlyBudgets) {
                if (monthlyBdgt.bdgtYear == currentYearSelected) {
                    activeBudgetsInSelectedYear++
                }
            }
            // Locking the proper date buttons
            for ((b,btn) in binding.cnstDateButtons.children.withIndex()) {
                btn.isClickable = b < activeBudgetsInSelectedYear
            }
        }
        // DATE SELECTION
        // int year = Calendar.getInstance().get(Calendar.YEAR)
        binding.tvSelectedYear.text = mainActivity.getInstanceOfViewModel().getCurrentYearDisplayed().toString()

        binding.btnYearForward.setOnClickListener {
            val currentYearPlusOne = binding.tvSelectedYear.text.toString().toInt() + 1
            for (monthlyBdgt in mainActivity.getInstanceOfViewModel().getCurrentBudget().bdgtAllMonthlyBudgets) {
                if (monthlyBdgt.bdgtYear == currentYearPlusOne) {
                    binding.tvSelectedYear.text = currentYearPlusOne.toString()
                    lockDateButtons(currentYearPlusOne)
                }
            }
        }

        binding.btnYearBack.setOnClickListener {
            val currentYearMinusOne = binding.tvSelectedYear.text.toString().toInt() - 1
            binding.tvSelectedYear.text = currentYearMinusOne.toString()
            lockDateButtons(currentYearMinusOne)
        }




        binding.btnBdgtDateSelection.setOnClickListener {
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



        binding.btnJan.setOnClickListener{
            budgetsVM.setCurrentDate("custom", mutableListOf(0))
        }
        for (button in binding.cnstDateButtons.children) {
            if (button.isClickable) {
                button.setOnClickListener {
                    when ((button as Button).text) {
                        "Jan" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(0))
                        }
                        "Feb" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(1))
                        }
                        "Mar" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(2))
                        }
                        "Apr" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(3))
                        }
                        "May" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(4))
                        }
                        "Jun" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(5))
                        }
                        "Jul" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(6))
                        }
                        "Aug" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(7))
                        }
                        "Sep" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(8))
                        }
                        "Oct" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(9))
                        }
                        "Nov" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(10))
                        }
                        "Dec" -> {
                            mainActivity.getInstanceOfViewModel().setCurrentDate("custom", mutableListOf(11))
                        }
                    }
                    populateCategoriesRecyclerView()
                    binding.cnstDateButtonsPerimeter.visibility = View.GONE
                }
            }

        }


    }

}