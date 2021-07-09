package com.example.dashboard.calculator.ui.history

import android.app.AlertDialog
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dashboard.R
import androidx.lifecycle.Observer
import com.example.dashboard.calculator.storage.database.CalcHistoryDao
import com.example.dashboard.calculator.storage.database.HistoryDatabase
import com.example.dashboard.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_history, container,false
        )

        val application: Application = requireNotNull(this.activity).application
        val dataSource: CalcHistoryDao = HistoryDatabase.getInstance(application).getCalcHistoryDao()

        val viewModelFactory = HistoryViewModelFactory(dataSource, application)

        val historyViewModel = ViewModelProvider(
            this, viewModelFactory).get(HistoryViewModel::class.java)

        binding.historyViewModel = historyViewModel

        binding.lifecycleOwner = this

        val adapter = HistoryAdapter()
        binding.calculationsList.adapter = adapter
        binding.calculationsList.layoutManager = LinearLayoutManager(this.activity)
        historyViewModel.getAllCalculations().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        binding.clearButton.setOnClickListener {
            AlertDialog.Builder(this.activity).also {
                it.setTitle("Verlauf löschen?")
                it.setMessage("Möchten Sie den Verlauf löschen?")
                it.setPositiveButton("Ja"){
                        dialog, which -> historyViewModel.onClear()
                }
                it.setNegativeButton("Abbrechen"){
                        dialog, which ->  dialog.cancel()
                }
            }.create().show()
        }
        return binding.root
    }
}
