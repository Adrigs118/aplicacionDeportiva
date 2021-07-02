package com.prueba.aplicaciondeportiva.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.prueba.aplicaciondeportiva.database.Dao.BodyDao
import com.prueba.aplicaciondeportiva.database.Dao.ConfigDao
import com.prueba.aplicaciondeportiva.database.Dao.DietDao
import com.prueba.aplicaciondeportiva.database.Dao.NotificationDao
import com.prueba.aplicaciondeportiva.database.Entity.*

@Database(entities = [DietEntity::class,
    DietDayEntity::class, BodyEntity::class, ConfigEntity::class, NotificationEntity::class],
    version = 1)
abstract class GymDatabase : RoomDatabase() {
    abstract  fun dietDao() : DietDao
    abstract  fun bodyDao() : BodyDao
    abstract  fun configDao() : ConfigDao
    abstract  fun notificationDao() : NotificationDao

    companion object {
        const val DATABASE_NAME = "gym_database"
        @Volatile
        private var INSTANCE: GymDatabase? = null

        fun getInstance(context: Context): GymDatabase? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    GymDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }




}