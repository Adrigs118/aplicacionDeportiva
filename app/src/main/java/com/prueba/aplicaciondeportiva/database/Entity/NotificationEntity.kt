package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Notification")
data class NotificationEntity (
    @SerializedName("_id") @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "_id") val id: String,
    @SerializedName("title") @ColumnInfo(name = "title") val title: String,
    @SerializedName("description") @ColumnInfo(name = "description") val description: String
    )