package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.prueba.aplicaciondeportiva.database.Repository.DateConverter
import java.sql.Date

@Entity(tableName = "Training")
data class TrainingEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Short,
    @ColumnInfo(name = "main") var main: Boolean,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "difficult") var difficult: Int,
    @ColumnInfo(name = "days") var days: Int,
    @ColumnInfo(name = "target") var target: String
)
