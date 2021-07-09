package com.example.dashboard.calculator.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CalculationHistory:: class], version = 1, exportSchema = false)
abstract class HistoryDatabase : RoomDatabase(){
    abstract fun getCalcHistoryDao() : CalcHistoryDao
    companion object {
        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext, HistoryDatabase::class.java,
                        "calculation_history_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance

            }
        }
    }
}