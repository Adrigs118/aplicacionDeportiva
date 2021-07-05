package com.prueba.aplicaciondeportiva.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity

@Dao
interface StrechtingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(body: BodyEntity)

    @Update
    suspend fun update(body: BodyEntity)

    @Delete
    suspend fun delete(body: BodyEntity)

    @Query("DELETE FROM Body")
    suspend fun deleteAll()

    @Query("SELECT * FROM Body")
    suspend fun getAll(): List<BodyEntity>
}