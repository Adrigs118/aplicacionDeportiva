package com.prueba.aplicaciondeportiva.database.Repository

import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Dao.DietDao
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.utils.DialogAux

class DietRepository (private val dao: DietDao){

    val diets = dao.getAll()

    suspend fun insert(entity : DietWithDay){
            dao.insert(entity.diet)
            for (day in entity.days){
                dao?.insertDay(day)
            }
    }

    suspend fun update(entity : DietWithDay) {
        dao.update(entity.diet)
        for (day in entity.days) {
            dao?.updateDay(day)
        }
    }

    suspend fun delete(entity : DietWithDay) {
        dao.delete(entity.diet)
        for (day in entity.days) {
            dao?.deleteDay(day)
        }
    }

    suspend fun deleteAll(entity : DietWithDay) {
        dao.deleteAll()
        for (day in entity.days) {
            dao?.deleteDay(day)
        }
    }
}