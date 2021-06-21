package com.prueba.aplicaciondeportiva.database.Dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.SettingsEntity

@Dao
interface SettingsDao {

    @Insert
    fun insert(settings: SettingsEntity)

    @Update
    fun update(vararg settings: SettingsEntity)

    @Delete
    fun delete(vararg  settings: SettingsEntity)

    @Query("SELECT * FROM " + SettingsEntity.TABLE_NAME)
    fun getSettings(): LiveData<List<SettingsEntity>>
}