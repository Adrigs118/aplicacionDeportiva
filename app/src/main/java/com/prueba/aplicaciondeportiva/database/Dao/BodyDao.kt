package com.prueba.aplicaciondeportiva.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity

@Dao
interface BodyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(body: BodyEntity)

    @Update
    suspend fun update(body: BodyEntity)

    @Delete
    suspend fun delete(body: BodyEntity)

    @Query("DELETE FROM Body")
    suspend fun deleteAll()

    @Query("SELECT * FROM Diet")
    fun getAll(): LiveData<List<BodyEntity>>
}