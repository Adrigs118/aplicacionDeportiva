package com.prueba.aplicaciondeportiva.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.prueba.aplicaciondeportiva.database.Dao.SettingsDao
import com.prueba.aplicaciondeportiva.database.Entity.SettingsEntity

@Database(entities = [SettingsEntity::class], version = 1)
abstract class GymDatabase : RoomDatabase() {
    abstract  fun settingsDao(): SettingsDao

    companion object {
        private  const val DATABASE_NAME = "gym_database"
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