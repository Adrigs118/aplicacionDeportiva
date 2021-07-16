package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Diet")
data class DietEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "tag") val tag: String
)


