package com.example.dashboard.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.dashboard.R
import com.example.dashboard.calculator.ui.calculator.CalculatorFragment


class Calculator : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_calculator)
//        val viewModel =ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        val navController = this.findNavController(R.id.fragment)

        navController.addOnDestinationChangedListener{controller, destination, arguments ->
            title = when (destination.id){
                R.id.calculatorFragment -> "Calculator"
                else -> "History"
            }

        }
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragment)
        return navController.navigateUp()


    }


}


