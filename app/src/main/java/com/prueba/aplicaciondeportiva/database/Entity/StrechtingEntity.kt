package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.prueba.aplicaciondeportiva.database.Repository.DateConverter
import java.sql.Date

@Entity(tableName = "Strechting")
data class StrechtingEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Short,
    @ColumnInfo(name = "tag") val tag: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "series") var series: Int,
    @ColumnInfo(name = "rep") var rep: Int,
    @ColumnInfo(name = "weight") var weight: Float,
    @ColumnInfo(name = "url") var url: String
)
