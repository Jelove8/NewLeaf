package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.adapters.EditCategoriesAdapter
import com.example.newleaf2022.databinding.FragmentEditCategoriesBinding
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class EditCategoriesFragment : Fragment() {

    private var fragmentBinding: FragmentEditCategoriesBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentBinding = FragmentEditCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcyEditableCategories.layoutManager = LinearLayoutManager(activity)
        val mainActivity = context as MainActivity
        val budgetsVM: BudgetsViewModel by activityViewModels()

        // Populating the recycler view
        var currentCategories = budgetsVM.getCurrentMonthlyBudget()
        if (currentCategories.isNullOrEmpty()) {
            currentCategories = arrayListOf()
        }
        fun populateCategoriesRecyclerView() {
            val newAdapter = EditCategoriesAdapter(budgetsVM.getAllCategories(), budgetsVM.getCategoryPositions())
            binding.rcyEditableCategories.adapter = newAdapter
        }
        populateCategoriesRecyclerView()




        

        binding.btnConfirmEdits.setOnClickListener {
            // Deleting categories & subcategories with empty names
            for ((i,item) in budgetsVM.getCurrentMonthlyBudget().withIndex()) {
                if (item.getName().equals(null) || item.getName().equals("")) {

                }
                else {
                    for ((j,subcategory) in item.getSubcategories().withIndex()) {
                        if (subcategory.getName().equals(null) || subcategory.getName().equals("")) {

                        }
                    }
                }
            }
            budgetsVM.updateModelBudget(mainActivity.getInstanceOfModel())
            mainActivity.changeFragment("main", DisplayCategoriesFragment())
        }

        binding.btnEditCategoriesCancel.setOnClickListener {
            mainActivity.changeFragment("main", DisplayCategoriesFragment())
        }

        binding.btnAddCategory.setOnClickListener {


        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }


}