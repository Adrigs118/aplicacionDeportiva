package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Config")
data class ConfigEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Short,
    @ColumnInfo(name = "init") val init: Boolean,
    @ColumnInfo(name = "language") var language: String
)
