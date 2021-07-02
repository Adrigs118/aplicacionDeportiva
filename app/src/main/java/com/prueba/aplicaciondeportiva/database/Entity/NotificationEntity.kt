package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notification")
data class NotificationEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Short,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String
    )