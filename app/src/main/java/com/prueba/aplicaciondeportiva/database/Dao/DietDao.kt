package com.prueba.aplicaciondeportiva.database.Dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.prueba.aplicaciondeportiva.database.Entity.DietDayEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay

@Dao
interface DietDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diet: DietEntity)

    @Insert
    suspend fun insertDay(day: DietDayEntity)

    @Update
    suspend fun update(diet: DietEntity)

    @Update
    suspend fun updateDay(diet: DietDayEntity)

    @Delete
    suspend fun delete(diet: DietEntity)

    @Delete
    suspend fun deleteDay(diet: DietDayEntity)

    @Query("DELETE FROM Diet")
    suspend fun deleteAll()

    @Query("SELECT * FROM Diet")
    suspend fun getAllDiet(): List<DietEntity>

    @Transaction
    @Query("SELECT * FROM Diet")
    fun getAll(): LiveData<List<DietWithDay>>

    @Transaction
    @Query("SELECT * FROM Diet WHERE name = :name")
    fun getByName(name : String): LiveData<DietWithDay>
}