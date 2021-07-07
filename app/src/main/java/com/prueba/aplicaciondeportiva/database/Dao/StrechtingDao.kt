package com.prueba.aplicaciondeportiva.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity

@Dao
interface StrechtingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(strechting: StrechtingEntity)

    @Update
    suspend fun update(strechting: StrechtingEntity)

    @Delete
    suspend fun delete(strechting: StrechtingEntity)

    @Query("DELETE FROM Strechting")
    suspend fun deleteAll()

    @Query("SELECT * FROM Strechting")
    suspend fun getAll(): List<StrechtingEntity>

    @Query("SELECT * FROM Strechting WHERE id = :id")
    suspend fun getById(id :Short): StrechtingEntity
}