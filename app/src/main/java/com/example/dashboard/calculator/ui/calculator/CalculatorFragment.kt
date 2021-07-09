package com.example.dashboard.calculator.ui.calculator

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dashboard.R
import com.example.dashboard.calculator.storage.database.CalcHistoryDao
import com.example.dashboard.calculator.storage.database.HistoryDatabase
import com.example.dashboard.databinding.FragmentCalculatorBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CalculatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class CalculatorFragment : Fragment() {
    private lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: FragmentCalculatorBinding

//    private val digits = listOf<>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i(tag, "Called ViewModelProviders.of")

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_calculator, container, false)


        val application: Application =  requireNotNull(this.activity).application
        val  dataSource: CalcHistoryDao = HistoryDatabase.getInstance(application).getCalcHistoryDao()
        val viewModelFactory = CalculatorViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CalculatorViewModel::class.java)
        binding.calculatorViewModel = viewModel

        binding.lifecycleOwner = this

        binding.historyButton.setOnClickListener {openHistory() }
//            view.findNavController()
//                .navigate(CalculatorFragmentDirections
//                    .actionCalculatorFragmentToHistory2())


        initializeButtons()
        return  binding.root
    }

    private fun openHistory() {
        val action = CalculatorFragmentDirections
            .actionCalculatorFragmentToHistoryFragment2()
        NavHostFragment.findNavController(this).navigate(action)
    }



    private fun initializeButtons(){
        functionalButtons()
        operationalButtons()
        numericalButtons()

    }

    private fun numericalButtons() {
        //number Buttons
        binding.oneButton.setOnClickListener {    displayAppendedDigit("1") }
        binding.twoButton.setOnClickListener {  displayAppendedDigit("2")  }
        binding.threeButton.setOnClickListener {  displayAppendedDigit("3") }
        binding.fourButton.setOnClickListener {    displayAppendedDigit("4")  }
        binding.fiveButton.setOnClickListener {   displayAppendedDigit("5")  }
        binding.sixButton.setOnClickListener {   displayAppendedDigit("6")  }
        binding.sevenButton.setOnClickListener {    displayAppendedDigit("7")  }
        binding.eightButton.setOnClickListener {   displayAppendedDigit("8")  }
        binding.nineButton.setOnClickListener {   displayAppendedDigit("9")  }
        binding.zeroButton.setOnClickListener {  displayAppendedDigit("0")  }
        binding.dotButton.setOnClickListener {    displayAppendedDigit(".") }
        binding.doSqr?.setOnClickListener {    displayAppendedDigit("^2") }


    }

    private fun operationalButtons() {
        //        operation Buttons
        binding.minusButton.setOnClickListener {
            displayOperationSymbol("-")

        }
        binding.plusButton.setOnClickListener {
            displayOperationSymbol("+")
        }
        binding.divideButton.setOnClickListener {
            displayOperationSymbol("/")
        }
        binding.multiplicationButton.setOnClickListener {
            displayOperationSymbol("*")
        }
        binding.doSqr?.setOnClickListener {
            displayOperationSymbol("^")
        }

    }

    private fun functionalButtons() {
//        handles the clear, backspace and equals button click
        binding.clearButton.setOnClickListener { clear() }
        binding.backSpaceButton.setOnClickListener { displayAfterClearDigit() }
        binding.equalButton.setOnClickListener { performMathOperation() }

    }

    private fun displayAfterClearDigit(){
        viewModel.clearDigit()
        binding.inputText.text = viewModel.digitOnScreen.toString()
        if (binding.result.text.isNotEmpty()){
            clear()
        }
    }

    private fun displayAppendedDigit(number: String){
        viewModel.appendToDigit(number)
        if (binding.inputText.text.isNotEmpty() && binding.result.text.isNotEmpty()) {
            clear()
            binding.inputText.text = viewModel.digitOnScreen.toString()
        }else{
            binding.inputText.text = viewModel.digitOnScreen.toString()
        }
    }
    private fun displayOperationSymbol(symbol: String) {
        viewModel.appendToDigit(symbol)
        if (binding.inputText.text.isNotEmpty() && binding.result.text.isNotEmpty()) {

            val newExpression = binding.result.text.toString() + symbol
            viewModel.digitOnScreen.clear()
            viewModel.digitOnScreen.append(newExpression)
            binding.result.text = ""
            binding.inputText.text = newExpression

        } else {
            binding.inputText.text = viewModel.digitOnScreen.toString()
        }
    }
    private fun performMathOperation(){
        if (binding.inputText.text.isNotEmpty()) {
            viewModel.calculation()
            binding.result.text = viewModel.result
            viewModel.save()
        }
    }

    private fun clear(){
        binding.inputText.text = ""
        binding.result.text = ""
        viewModel.digitOnScreen.clear()
    }

}