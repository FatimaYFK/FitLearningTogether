package com.example.dashboard.calculator.storage.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calculation_history")
data class CalculationHistory(
    @PrimaryKey(autoGenerate = true)
    var calculationId: Long = 0L,

    @ColumnInfo(name = "calculation_time")
    val calculationTime: String? = null,

    @ColumnInfo(name = "calculation_expression")
    var calculationExpression: String? = null,

    @ColumnInfo(name = "calculation_result")
    var calculationResult: String? = null
)