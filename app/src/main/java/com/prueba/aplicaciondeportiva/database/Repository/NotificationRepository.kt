package com.prueba.aplicaciondeportiva.database.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prueba.aplicaciondeportiva.database.Dao.NotificationDao
import com.prueba.aplicaciondeportiva.database.Entity.NotificationEntity

class NotificationRepository (private val dao: NotificationDao){

    val notifications = dao.getAll()

    suspend fun insert(entity : NotificationEntity){
        dao.insert(entity)
    }

    suspend fun delete(entity : NotificationEntity) {
        dao.delete(entity)
    }

    suspend fun deleteAll(entity : NotificationEntity) {
        dao.deleteAll()
    }

    fun getAll() : LiveData<List<NotificationEntity>> {
        return dao.getAll()
    }
}