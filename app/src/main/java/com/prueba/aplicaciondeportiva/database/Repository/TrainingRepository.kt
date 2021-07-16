package com.prueba.aplicaciondeportiva.database.Repository

import androidx.lifecycle.LiveData
import com.prueba.aplicaciondeportiva.database.Dao.BodyDao
import com.prueba.aplicaciondeportiva.database.Dao.TrainingDao
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.TrainingEntity

class TrainingRepository (private val dao: TrainingDao){

    val trainings = dao.getAll()

    suspend fun insert(entity : TrainingEntity){
        dao.insert(entity)
    }

    suspend fun update(entity : TrainingEntity) {
        dao.update(entity)
    }

    suspend fun delete(entity : TrainingEntity) {
        dao.delete(entity)
    }

    suspend fun deleteAll(entity : TrainingEntity) {
        dao.deleteAll()
    }
}