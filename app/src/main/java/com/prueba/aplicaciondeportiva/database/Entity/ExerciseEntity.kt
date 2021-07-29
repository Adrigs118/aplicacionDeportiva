package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.prueba.aplicaciondeportiva.database.Repository.DateConverter
import java.sql.Date

@Entity(tableName = "Exercise")
data class ExerciseEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Short,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "series") var series: Int,
    @ColumnInfo(name = "rep") var rep: Int,
    @ColumnInfo(name = "weight") var weight: Float,
    @ColumnInfo(name = "tag") var tag: String
)
