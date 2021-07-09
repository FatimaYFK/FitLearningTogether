package com.example.dashboard.calculator.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dashboard.calculator.storage.database.CalcHistoryDao
import com.example.dashboard.calculator.storage.database.CalculationHistory
import kotlinx.coroutines.*

class HistoryViewModel(
    val database: CalcHistoryDao, application: Application
) : AndroidViewModel(application) {
    private var viewModelJOb = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJOb)
    private var calculation = MutableLiveData<CalculationHistory?>()


    fun onClear() {
        uiScope.launch {
            clear()
            calculation.value = null
        }
    }

    fun getAllCalculations(): LiveData<List<CalculationHistory>> {
        return database.getAllCalculations()

    }
    suspend fun clear(){
        withContext(Dispatchers.IO){
            database.clear()
        }

    }


    override fun onCleared() {
        super.onCleared()
        viewModelJOb.cancel()
    }
}
