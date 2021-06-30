package com.prueba.aplicaciondeportiva.database.Repository

import com.prueba.aplicaciondeportiva.database.Dao.BodyDao
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity

class BodyRepository (private val dao: BodyDao){

    val body = dao.getAll().value?.first()

    suspend fun insert(entity : BodyEntity){
        dao.insert(entity)
    }

    suspend fun update(entity : BodyEntity) {
        dao.update(entity)
    }

    suspend fun delete(entity : BodyEntity) {
        dao.delete(entity)
    }

    suspend fun deleteAll(entity : BodyEntity) {
        dao.deleteAll()
    }
}