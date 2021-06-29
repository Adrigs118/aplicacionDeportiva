package com.prueba.aplicaciondeportiva.viewModel.nutrition

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietDayEntity

class DietDescriptionViewModel :ViewModel() {

    private lateinit var day :DietDayEntity

    fun setDay(day : DietDayEntity){
        this.day = day
    }

}