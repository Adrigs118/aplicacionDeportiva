package com.prueba.aplicaciondeportiva.database.Repository

import androidx.room.TypeConverter
import java.sql.Date


public class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return (if (date == null) null else date!!.getTime())!!.toLong()
    }
}