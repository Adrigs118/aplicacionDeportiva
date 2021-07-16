package com.prueba.aplicaciondeportiva.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.TrainingEntity

@Dao
interface TrainingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(body: TrainingEntity)

    @Update
    suspend fun update(body: TrainingEntity)

    @Delete
    suspend fun delete(body: TrainingEntity)

    @Query("DELETE FROM Training")
    suspend fun deleteAll()

    @Query("SELECT * FROM Training")
    fun getAll(): LiveData<List<TrainingEntity>>
}