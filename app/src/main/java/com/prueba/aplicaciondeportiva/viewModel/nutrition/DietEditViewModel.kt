package com.prueba.aplicaciondeportiva.viewModel.nutrition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.DietRepository
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlinx.android.synthetic.main.fragment_diet_edit.*

class DietEditViewModel : ViewModel(){

    val repository = DietRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.dietDao())


    fun insert(entity : DietWithDay) : Boolean{
        try{
            viewModelScope.launch {
                repository.insert(entity)
            }
            return true
        }
        catch (e :Exception){
            return false
        }
    }

    fun delete(entity : DietWithDay) :Boolean{
        try{
            viewModelScope.launch {
                repository.delete(entity)
            }
            return true
        }
        catch (e:Exception){
            return false
        }
    }

    fun updateDiet(entity : DietWithDay) :Boolean{
        try{
            viewModelScope.launch {
                repository.update(entity)
            }
            return true
        }
        catch (e :Exception){
            return false
        }
    }
}