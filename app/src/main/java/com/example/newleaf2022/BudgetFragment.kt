package com.example.newleaf2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        // Displaying the proper budget depending on the date
        val currentDate = Date()


        // Populating the recycler view

        // These are the arrays that will be passed into the recyclerview.
        // The first array is a list of all categories and subcategories
        // The second array is a list of integers that identify which indexes of allCategories contain categories
        var allCategories = arrayListOf<Categories>()
        var categoryPositions = arrayListOf<Int>()
        var categoryCount = 0
        for (category in budgetsVM.getCurrentMonthlyBudget()) {
            allCategories.add(category)
            categoryPositions.add(categoryCount)
            categoryCount++
            for (subcategory in category.getSubcategories()) {
                allCategories.add(subcategory)
                categoryCount++
            }
        }

        val newAdapter = CategoryAdapter(allCategories, categoryPositions, budgetsVM, binding.outputTotalUnassigned)

        binding.fragBudgetsRecycler.adapter = newAdapter
        newAdapter.setOnTextChangedListener(object: CategoryAdapter.OnTextChangedListener{
            override fun onTextChanged(position: Int) {

            }
        })








        // Populating RecyclerView

        binding.btnMisc1.setOnClickListener {

        }
        binding.btnChangeDate.setOnClickListener {

        }
        binding.btnEditBudget.setOnClickListener {
            mainActivity.changeFragment("main", EditCategoriesFragment())
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}