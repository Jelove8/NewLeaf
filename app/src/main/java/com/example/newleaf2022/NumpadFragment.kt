package com.example.newleaf2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newleaf2022.databinding.FragmentNumpadBinding


class NumpadFragment : Fragment() {

    private var fragmentBinding: FragmentNumpadBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentBinding = FragmentNumpadBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputIntegersList = mutableListOf<String>()
        fun updateOutput() {
            var outputString = ""
            var leftOfDecimalPoint = ""
            var rightOfDecimalPoint = ""

            when (inputIntegersList.size) {
                0 -> {
                    outputString = "0.00"
                }
                1 -> {
                    outputString = "0.0${inputIntegersList[0]}"
                }
                2 -> {
                    rightOfDecimalPoint = inputIntegersList[0] + inputIntegersList[1]
                    outputString = "0.$rightOfDecimalPoint"
                }
                else -> {
                    rightOfDecimalPoint = "." + inputIntegersList[inputIntegersList.size - 2] + inputIntegersList[inputIntegersList.size - 1]
                    for ((i,item) in inputIntegersList.withIndex()) {
                        if (i < (inputIntegersList.size - 2)) {
                            leftOfDecimalPoint += item
                        }
                    }
                    outputString = leftOfDecimalPoint + rightOfDecimalPoint
                }
            }
            binding.tvNumpadValue.text = outputString

        }



        binding.btn1.setOnClickListener {
            inputIntegersList.add("1")
            updateOutput()
        }
        binding.btn2.setOnClickListener {
            inputIntegersList.add("2")
            updateOutput()
        }
        binding.btn3.setOnClickListener {
            inputIntegersList.add("3")
            updateOutput()
        }
        binding.btn4.setOnClickListener {
            inputIntegersList.add("4")
            updateOutput()
        }
        binding.btn5.setOnClickListener {
            inputIntegersList.add("5")
            updateOutput()
        }
        binding.btn6.setOnClickListener {
            inputIntegersList.add("6")
            updateOutput()
        }
        binding.btn7.setOnClickListener {
            inputIntegersList.add("7")
            updateOutput()
        }
        binding.btn8.setOnClickListener {
            inputIntegersList.add("8")
            updateOutput()
        }
        binding.btn9.setOnClickListener {
            inputIntegersList.add("9")
            updateOutput()
        }
        binding.btn0.setOnClickListener {
            inputIntegersList.add("0")
            updateOutput()
        }

        binding.btnBackSpace.setOnClickListener {
            if (inputIntegersList.size != 0) {
                inputIntegersList.removeAt((inputIntegersList.size - 1))
                updateOutput()
            }
        }
        binding.btnCancelNumpad.setOnClickListener {
            inputIntegersList.clear()
            updateOutput()
        }
        binding.btnConfirmNumpad.setOnClickListener {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }


}