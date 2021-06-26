package com.prueba.aplicaciondeportiva

import java.sql.Time
import java.text.DecimalFormat

//class que representa los valores del cuerpo del sujeto
class Body {

    //region variables
    private var gender : Gender = Gender.MALE
    private var age : Short? = null
    private var weight : Float? = null
    private var height : Short? = null

    private var imc : Double? = null
    private var ideal_weight : Float? = null

    private var fat : Float? = null
    private var muscle : Float? = null
    private var bone : Float? = null
    private var water : Float? = null

    private var left_bicep : Short? = null
    private var right_bicep : Short? = null
    private var chest : Short? = null
    private var waist : Short? = null

    private var map_weight : Map<Time, Float>? = null
    private var map_imc : Map<Time, Double>? = null

    private var map_fat : Map<Time, Float>? = null
    private var map_muscle : Map<Time, Float>? = null
    private var map_bone : Map<Time, Float>? = null
    private var map_water : Map<Time, Float>? = null

    private var map_left_bicep : Map<Time, Short>? = null
    private var map_right_bicep : Map<Time, Short>? = null
    private var map_chest : Map<Time, Short>? = null
    private var map_waist : Map<Time, Short>? = null
    //endregion

    //region getters
    fun getSex() : Body.Gender {return gender}
    fun getAge() : Short? {return age}
    fun getWeight() : Float? {return weight}
    fun getHeight() : Short? {return height}
    fun getImc() : Double? {return imc}
    //endregion

    //region setters
    fun setGender(gender : Gender) { this.gender = gender}
    fun setAge(age : Short) { this.age = age}
    fun setWeight(weight : Float) { this.weight = weight}
    fun setHeight(height : Short) { this.height = height}
    fun setImc(imc : Double) { this.imc = imc}
    //endregion

    enum class Gender {MALE, FEMALE}

}