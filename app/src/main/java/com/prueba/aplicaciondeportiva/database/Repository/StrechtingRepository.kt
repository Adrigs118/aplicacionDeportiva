package com.prueba.aplicaciondeportiva.database.Repository

import androidx.lifecycle.LiveData
import com.prueba.aplicaciondeportiva.database.Dao.BodyDao
import com.prueba.aplicaciondeportiva.database.Dao.StrechtingDao
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity

class StrechtingRepository (private val dao: StrechtingDao){

    suspend fun insert(entity : StrechtingEntity){
        dao.insert(entity)
    }

    suspend fun update(entity : StrechtingEntity) {
        dao.update(entity)
    }

    suspend fun delete(entity : StrechtingEntity) {
        dao.delete(entity)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

    suspend fun getAll() : List<StrechtingEntity>{
        return dao.getAll()
    }

    suspend fun getById(id : Short) : StrechtingEntity{
        return dao.getById(id)
    }
}