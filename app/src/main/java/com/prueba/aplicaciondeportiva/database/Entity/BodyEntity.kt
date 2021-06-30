package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Body")
data class BodyEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "genre") val genre: Int,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "weight") val weight: Float,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "imc") val imc: Double
)
