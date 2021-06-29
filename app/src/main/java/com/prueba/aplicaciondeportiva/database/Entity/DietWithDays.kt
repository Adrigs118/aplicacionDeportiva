package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.Embedded
import androidx.room.Relation

class DietWithDay() {
    @Embedded lateinit var diet: DietEntity
    @Relation(
        parentColumn = "name",
        entityColumn = "diet"
    )
    lateinit var days: List<DietDayEntity>
}