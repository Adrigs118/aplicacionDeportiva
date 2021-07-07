package com.prueba.aplicaciondeportiva.database.Dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.NotificationEntity

@Dao
interface NotificationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(body: NotificationEntity)

    @Delete
    suspend fun delete(body: NotificationEntity)

    @Query("DELETE FROM Notification")
    suspend fun deleteAll()

    @Query("SELECT * FROM Notification")
    fun getAll(): LiveData<List<NotificationEntity>>
}