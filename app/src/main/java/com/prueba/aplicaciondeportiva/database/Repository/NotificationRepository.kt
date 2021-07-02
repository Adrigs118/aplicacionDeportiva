package com.prueba.aplicaciondeportiva.database.Repository

import androidx.lifecycle.LiveData
import com.prueba.aplicaciondeportiva.database.Dao.NotificationDao
import com.prueba.aplicaciondeportiva.database.Entity.NotificationEntity

class NotificationRepository (private val dao: NotificationDao){

    suspend fun insert(entity : NotificationEntity){
        dao.insert(entity)
    }

    suspend fun delete(entity : NotificationEntity) {
        dao.delete(entity)
    }

    suspend fun deleteAll(entity : NotificationEntity) {
        dao.deleteAll()
    }

    fun getAll() : LiveData<List<NotificationEntity>>{
        return dao.getAll()
    }
}