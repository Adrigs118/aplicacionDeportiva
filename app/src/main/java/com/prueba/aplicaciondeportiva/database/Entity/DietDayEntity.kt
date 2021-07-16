package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.*

@Entity(tableName = "dietday", primaryKeys = ["day", "diet"])
data class DietDayEntity (
    @ColumnInfo(name = "day") val day: String,
    @ColumnInfo(name = "diet") val diet: String,
    @ColumnInfo(name = "breakfast") var breakfast: String,
    @ColumnInfo(name = "lunch") val lunch: String,
    @ColumnInfo(name = "meal") val meal: String,
    @ColumnInfo(name = "snack") val snack: String,
    @ColumnInfo(name = "dinner") val dinner: String
)
