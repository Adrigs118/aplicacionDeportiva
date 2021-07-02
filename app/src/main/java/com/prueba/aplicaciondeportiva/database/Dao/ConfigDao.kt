package com.prueba.aplicaciondeportiva.database.Dao

import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.ConfigEntity

@Dao
interface ConfigDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(config: ConfigEntity)

    @Update
    suspend fun update(config: ConfigEntity)

    @Query("SELECT * FROM Config WHERE id = 0")
    suspend fun get(): ConfigEntity
}