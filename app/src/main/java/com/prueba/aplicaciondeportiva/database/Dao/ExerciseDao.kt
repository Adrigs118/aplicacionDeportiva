package com.prueba.aplicaciondeportiva.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.Entity.ExerciseEntity
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exercise: ExerciseEntity)

    @Update
    suspend fun update(exercise: ExerciseEntity)

    @Delete
    suspend fun delete(exercise: ExerciseEntity)

    @Query("DELETE FROM Exercise")
    suspend fun deleteAll()

    @Query("SELECT * FROM Exercise")
    fun getAll(): LiveData<List<ExerciseEntity>>

    @Query("SELECT * FROM Exercise WHERE id = :id")
    suspend fun getById(id :Short): ExerciseEntity
}