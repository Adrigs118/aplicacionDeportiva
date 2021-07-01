package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.prueba.aplicaciondeportiva.database.Repository.DateConverter
import java.sql.Date

@Entity(tableName = "Body")  @TypeConverters(DateConverter::class)
data class BodyEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Short,
    @ColumnInfo(name = "gender") val gender: Boolean,
    @ColumnInfo(name = "age") var age: Int,
    @ColumnInfo(name = "weight") var weight: Float,
    @ColumnInfo(name = "height") var height: Int,
    @ColumnInfo(name = "imc") var imc: Double
)
