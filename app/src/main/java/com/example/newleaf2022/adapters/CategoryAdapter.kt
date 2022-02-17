package com.example.newleaf2022.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.example.newleaf2022.MainActivity
import com.example.newleaf2022.R
import com.example.newleaf2022.dataclasses.Categories
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class CategoryAdapter(private val categories: ArrayList<Categories>, private val budgetsVM: BudgetsViewModel, private val mainActivity: MainActivity) : RecyclerView.Adapter<CategoryAdapter.BudgetsViewHolder>() {

    class BudgetsViewHolder(ItemView: View, budgetsVM: BudgetsViewModel) : RecyclerView.ViewHolder(ItemView) {
        val mainCategory: TextView = itemView.findViewById(R.id.mainCategoryTV)
        val categoriesConstraint: ConstraintLayout = itemView.findViewById(R.id.categoriesConstraint)
        val subcategoriesConstraint: LinearLayout = itemView.findViewById(R.id.subcategoriesLinearLayout)

        val subcategory1: ConstraintLayout = itemView.findViewById(R.id.subcategory1)
        val subcategory2: ConstraintLayout = itemView.findViewById(R.id.subcategory2)
        val subcategory3: ConstraintLayout = itemView.findViewById(R.id.subcategory3)
        val subcategory4: ConstraintLayout = itemView.findViewById(R.id.subcategory4)
        val subcategory5: ConstraintLayout = itemView.findViewById(R.id.subcategory5)
        val subcategory6: ConstraintLayout = itemView.findViewById(R.id.subcategory6)
        val subcategory7: ConstraintLayout = itemView.findViewById(R.id.subcategory7)
        val subcategory8: ConstraintLayout = itemView.findViewById(R.id.subcategory8)
        val subcategory9: ConstraintLayout = itemView.findViewById(R.id.subcategory9)
        val subcategory10: ConstraintLayout = itemView.findViewById(R.id.subcategory10)
        val subcategory11: ConstraintLayout = itemView.findViewById(R.id.subcategory11)
        val subcategory12: ConstraintLayout = itemView.findViewById(R.id.subcategory12)
        val subcategory13: ConstraintLayout = itemView.findViewById(R.id.subcategory13)
        val subcategory14: ConstraintLayout = itemView.findViewById(R.id.subcategory14)
        val subcategory15: ConstraintLayout = itemView.findViewById(R.id.subcategory15)
        val subcategory16: ConstraintLayout = itemView.findViewById(R.id.subcategory16)

        val sub1: TextView = itemView.findViewById(R.id.sub1)
        val sub2: TextView = itemView.findViewById(R.id.sub2)
        val sub3: TextView = itemView.findViewById(R.id.sub3)
        val sub4: TextView = itemView.findViewById(R.id.sub4)
        val sub5: TextView = itemView.findViewById(R.id.sub5)
        val sub6: TextView = itemView.findViewById(R.id.sub6)
        val sub7: TextView = itemView.findViewById(R.id.sub7)
        val sub8: TextView = itemView.findViewById(R.id.sub8)
        val sub9: TextView = itemView.findViewById(R.id.sub9)
        val sub10: TextView = itemView.findViewById(R.id.sub10)
        val sub11: TextView = itemView.findViewById(R.id.sub11)
        val sub12: TextView = itemView.findViewById(R.id.sub12)
        val sub13: TextView = itemView.findViewById(R.id.sub13)
        val sub14: TextView = itemView.findViewById(R.id.sub14)
        val sub15: TextView = itemView.findViewById(R.id.sub15)
        val sub16: TextView = itemView.findViewById(R.id.sub16)

        val totalAssigned: TextView = itemView.findViewById(R.id.outputTotalAssigned)
        val totalAvailable: TextView = itemView.findViewById(R.id.outputTotalAvailable)

        val assigned1: EditText = itemView.findViewById(R.id.assigned1)
        val assigned2: EditText = itemView.findViewById(R.id.assigned2)
        val assigned3: EditText = itemView.findViewById(R.id.assigned3)
        val assigned4: EditText = itemView.findViewById(R.id.assigned4)
        val assigned5: EditText = itemView.findViewById(R.id.assigned5)
        val assigned6: EditText = itemView.findViewById(R.id.assigned6)
        val assigned7: EditText = itemView.findViewById(R.id.assigned7)
        val assigned8: EditText = itemView.findViewById(R.id.assigned8)
        val assigned9: EditText = itemView.findViewById(R.id.assigned9)
        val assigned10: EditText = itemView.findViewById(R.id.assigned10)
        val assigned11: EditText = itemView.findViewById(R.id.assigned11)
        val assigned12: EditText = itemView.findViewById(R.id.assigned12)
        val assigned13: EditText = itemView.findViewById(R.id.assigned13)
        val assigned14: EditText = itemView.findViewById(R.id.assigned14)
        val assigned15: EditText = itemView.findViewById(R.id.assigned15)
        val assigned16: EditText = itemView.findViewById(R.id.assigned16)

        val available1: EditText = itemView.findViewById(R.id.available1)
        val available2: EditText = itemView.findViewById(R.id.available2)
        val available3: EditText = itemView.findViewById(R.id.available3)
        val available4: EditText = itemView.findViewById(R.id.available4)
        val available5: EditText = itemView.findViewById(R.id.available5)
        val available6: EditText = itemView.findViewById(R.id.available6)
        val available7: EditText = itemView.findViewById(R.id.available7)
        val available8: EditText = itemView.findViewById(R.id.available8)
        val available9: EditText = itemView.findViewById(R.id.available9)
        val available10: EditText = itemView.findViewById(R.id.available10)
        val available11: EditText = itemView.findViewById(R.id.available11)
        val available12: EditText = itemView.findViewById(R.id.available12)
        val available13: EditText = itemView.findViewById(R.id.available13)
        val available14: EditText = itemView.findViewById(R.id.available14)
        val available15: EditText = itemView.findViewById(R.id.available15)
        val available16: EditText = itemView.findViewById(R.id.available16)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)

        return BudgetsViewHolder(view, budgetsVM)
    }

    override fun onBindViewHolder(holder: BudgetsViewHolder, position: Int) {

        var subAssignedInputs = arrayListOf<EditText>()
        var subAvailableInputs = arrayListOf<EditText>()

        var importAssignedInputs = arrayListOf<String>()
        var importAvailableInputs = arrayListOf<String>()

        var newAssignedInputs = arrayListOf<Double>()
        var newAvailableInputs = arrayListOf<Double>()


        // Hides unused views
        fun initializeVHData(interval: Int) {
            when (interval) {
                1 -> {
                    holder.subcategory2.visibility = View.GONE
                    holder.subcategory3.visibility = View.GONE
                    holder.subcategory4.visibility = View.GONE
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)

                    subAvailableInputs.add(holder.available1)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                }
                2 -> {
                    holder.subcategory3.visibility = View.GONE
                    holder.subcategory4.visibility = View.GONE
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                }
                3 -> {
                    holder.subcategory4.visibility = View.GONE
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                }
                4 -> {
                    holder.subcategory5.visibility = View.GONE
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                }
                5 -> {
                    holder.subcategory6.visibility = View.GONE
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                }
                6 -> {
                    holder.subcategory7.visibility = View.GONE
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                }
                7 -> {
                    holder.subcategory8.visibility = View.GONE
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                }
                8 -> {
                    holder.subcategory9.visibility = View.GONE
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                }
                9 -> {
                    holder.subcategory10.visibility = View.GONE
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                }
                10 -> {
                    holder.subcategory11.visibility = View.GONE
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)
                    subAssignedInputs.add(holder.assigned10)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)
                    subAvailableInputs.add(holder.available10)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[9].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[9].available.toString())
                }
                11 -> {
                    holder.subcategory12.visibility = View.GONE
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)
                    subAssignedInputs.add(holder.assigned10)
                    subAssignedInputs.add(holder.assigned11)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)
                    subAvailableInputs.add(holder.available10)
                    subAvailableInputs.add(holder.available11)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[9].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[10].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[9].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[10].available.toString())
                }
                12 -> {
                    holder.subcategory13.visibility = View.GONE
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)
                    subAssignedInputs.add(holder.assigned10)
                    subAssignedInputs.add(holder.assigned11)
                    subAssignedInputs.add(holder.assigned12)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)
                    subAvailableInputs.add(holder.available10)
                    subAvailableInputs.add(holder.available11)
                    subAvailableInputs.add(holder.available12)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[9].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[10].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[11].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[9].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[10].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[11].available.toString())
                }
                13 -> {
                    holder.subcategory14.visibility = View.GONE
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)
                    subAssignedInputs.add(holder.assigned10)
                    subAssignedInputs.add(holder.assigned11)
                    subAssignedInputs.add(holder.assigned12)
                    subAssignedInputs.add(holder.assigned13)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)
                    subAvailableInputs.add(holder.available10)
                    subAvailableInputs.add(holder.available11)
                    subAvailableInputs.add(holder.available12)
                    subAvailableInputs.add(holder.available13)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[9].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[10].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[11].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[12].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[9].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[10].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[11].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[12].available.toString())

                }
                14 -> {
                    holder.subcategory15.visibility = View.GONE
                    holder.subcategory16.visibility = View.GONE

                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)
                    subAssignedInputs.add(holder.assigned10)
                    subAssignedInputs.add(holder.assigned11)
                    subAssignedInputs.add(holder.assigned12)
                    subAssignedInputs.add(holder.assigned13)
                    subAssignedInputs.add(holder.assigned14)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)
                    subAvailableInputs.add(holder.available10)
                    subAvailableInputs.add(holder.available11)
                    subAvailableInputs.add(holder.available12)
                    subAvailableInputs.add(holder.available13)
                    subAvailableInputs.add(holder.available14)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[9].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[10].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[11].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[12].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[13].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[9].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[10].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[11].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[12].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[13].available.toString())
                }
                15 -> {
                    holder.subcategory16.visibility = View.GONE
                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)
                    subAssignedInputs.add(holder.assigned10)
                    subAssignedInputs.add(holder.assigned11)
                    subAssignedInputs.add(holder.assigned12)
                    subAssignedInputs.add(holder.assigned13)
                    subAssignedInputs.add(holder.assigned14)
                    subAssignedInputs.add(holder.assigned15)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)
                    subAvailableInputs.add(holder.available10)
                    subAvailableInputs.add(holder.available11)
                    subAvailableInputs.add(holder.available12)
                    subAvailableInputs.add(holder.available13)
                    subAvailableInputs.add(holder.available14)
                    subAvailableInputs.add(holder.available15)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[9].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[10].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[11].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[12].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[13].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[14].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[9].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[10].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[11].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[12].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[13].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[14].available.toString())
                }
                16 -> {
                    subAssignedInputs.add(holder.assigned1)
                    subAssignedInputs.add(holder.assigned2)
                    subAssignedInputs.add(holder.assigned3)
                    subAssignedInputs.add(holder.assigned4)
                    subAssignedInputs.add(holder.assigned5)
                    subAssignedInputs.add(holder.assigned6)
                    subAssignedInputs.add(holder.assigned7)
                    subAssignedInputs.add(holder.assigned8)
                    subAssignedInputs.add(holder.assigned9)
                    subAssignedInputs.add(holder.assigned10)
                    subAssignedInputs.add(holder.assigned11)
                    subAssignedInputs.add(holder.assigned12)
                    subAssignedInputs.add(holder.assigned13)
                    subAssignedInputs.add(holder.assigned14)
                    subAssignedInputs.add(holder.assigned15)
                    subAssignedInputs.add(holder.assigned16)

                    subAvailableInputs.add(holder.available1)
                    subAvailableInputs.add(holder.available2)
                    subAvailableInputs.add(holder.available3)
                    subAvailableInputs.add(holder.available4)
                    subAvailableInputs.add(holder.available5)
                    subAvailableInputs.add(holder.available6)
                    subAvailableInputs.add(holder.available7)
                    subAvailableInputs.add(holder.available8)
                    subAvailableInputs.add(holder.available9)
                    subAvailableInputs.add(holder.available10)
                    subAvailableInputs.add(holder.available11)
                    subAvailableInputs.add(holder.available12)
                    subAvailableInputs.add(holder.available13)
                    subAvailableInputs.add(holder.available14)
                    subAvailableInputs.add(holder.available15)
                    subAvailableInputs.add(holder.available16)

                    importAssignedInputs.add(categories[position].subcategories[0].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[1].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[2].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[3].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[4].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[5].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[6].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[7].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[8].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[9].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[10].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[11].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[12].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[13].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[14].assigned.toString())
                    importAssignedInputs.add(categories[position].subcategories[15].assigned.toString())

                    importAvailableInputs.add(categories[position].subcategories[0].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[1].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[2].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[3].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[4].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[5].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[6].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[7].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[8].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[9].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[10].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[11].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[12].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[13].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[14].available.toString())
                    importAvailableInputs.add(categories[position].subcategories[15].available.toString())
                }
                else -> {
                    holder.subcategoriesConstraint.visibility = View.GONE
                }
            }
        }
        initializeVHData(categories[position].subcategories.size)

        // Logic for each individual viewholder
        if (categories[position].name.contentEquals("NULL!")) {
            // Hides all views
            initializeVHData(0)
        }
        else {
            // Sets category data
            holder.mainCategory.text = categories[position].name
            holder.totalAssigned.text = categories[position].totalAssigned.toString()
            holder.totalAvailable.text = categories[position].totalAvailable.toString()


            // Sets subcategory names
            val limit = categories[position].subcategories.size
            for (i in 0 until limit) {
                val name = categories[position].subcategories[i].name
                when (i) {
                    0 -> {
                        holder.sub1.text = name
                    }
                    1 -> {
                        holder.sub2.text = name
                    }
                    2 -> {
                        holder.sub3.text = name
                    }
                    3 -> {
                        holder.sub4.text = name
                    }
                    4 -> {
                        holder.sub5.text = name
                    }
                    5 -> {
                        holder.sub6.text = name
                    }
                    6 -> {
                        holder.sub7.text = name
                    }
                    7 -> {
                        holder.sub8.text = name
                    }
                    8 -> {
                        holder.sub9.text = name
                    }
                    9 -> {
                        holder.sub10.text = name
                    }
                    10 -> {
                        holder.sub11.text = name
                    }
                    11 -> {
                        holder.sub12.text = name
                    }
                    12 -> {
                        holder.sub13.text = name
                    }
                    13 -> {
                        holder.sub14.text = name
                    }
                    14 -> {
                        holder.sub15.text = name
                    }
                    15 -> {
                        holder.sub16.text = name
                    }
                    else -> {}
                }
            }

            // Sets other subcategory data
            subAssignedInputs.withIndex().forEach { (itemCount, item) ->
                item.setText(categories[position].subcategories[itemCount].assigned.toString())
                item.doAfterTextChanged {
                    categories[position].subcategories[itemCount].assigned = item.text.toString().toDouble()
                    budgetsVM.updateCategories(categories, mainActivity)
                }
            }
            subAvailableInputs.withIndex().forEach { (itemCount, item) ->
                item.setText(categories[position].subcategories[itemCount].available.toString())
                item.doAfterTextChanged {
                     categories[position].subcategories[itemCount].available = item.text.toString().toDouble()
                    budgetsVM.updateCategories(categories, mainActivity)
                }
            }



        }




        holder.assigned1.doAfterTextChanged {
            budgetsVM.assignedValues.value?.set(position, holder.assigned1.text.toString().toDouble())
            val meow = budgetsVM.assignedValues.value?.get(position)?.toString()
        }

    }

    override fun getItemCount(): Int {
        return categories.size
    }
}