package com.prueba.aplicaciondeportiva.database.Repository

import androidx.lifecycle.LiveData
import com.prueba.aplicaciondeportiva.database.Dao.BodyDao
import com.prueba.aplicaciondeportiva.database.Dao.ExerciseDao
import com.prueba.aplicaciondeportiva.database.Dao.StrechtingDao
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.ExerciseEntity
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity

class ExerciseRepository (private val dao: ExerciseDao){

    val exercises = getAll()

    suspend fun insert(entity : ExerciseEntity){
        dao.insert(entity)
    }

    suspend fun update(entity : ExerciseEntity) {
        dao.update(entity)
    }

    suspend fun delete(entity : ExerciseEntity) {
        dao.delete(entity)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

    fun getAll() : LiveData<List<ExerciseEntity>>{
        return dao.getAll()
    }

    suspend fun getById(id : Short) : ExerciseEntity{
        return dao.getById(id)
    }
}