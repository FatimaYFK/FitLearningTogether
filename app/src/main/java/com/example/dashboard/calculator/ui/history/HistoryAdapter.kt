package com.example.dashboard.calculator.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.calculator.storage.database.CalculationHistory

class HistoryAdapter (): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    var data = listOf<CalculationHistory>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val expression: TextView = itemView.findViewById(R.id.expressionText)
        val result: TextView = itemView.findViewById(R.id.resultText)
        val time: TextView = itemView.findViewById(R.id.timeText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(
            R.layout.history_list_item,
            parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val history = data[position]
        val res = holder.itemView.context.resources
        holder.time.text = history.calculationTime.toString()
        holder.expression.text = history.calculationExpression
        holder.result.text =history.calculationResult
    }
}