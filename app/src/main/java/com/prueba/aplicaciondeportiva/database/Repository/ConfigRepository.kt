package com.prueba.aplicaciondeportiva.database.Repository

import com.prueba.aplicaciondeportiva.database.Dao.ConfigDao
import com.prueba.aplicaciondeportiva.database.Entity.ConfigEntity

class ConfigRepository (private val dao: ConfigDao){

    suspend fun insert(entity : ConfigEntity){
        dao.insert(entity)
    }

    suspend fun update(entity : ConfigEntity) {
        dao.update(entity)
    }

    suspend fun get() : ConfigEntity{
        return dao.get()
    }
}