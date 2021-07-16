package com.prueba.aplicaciondeportiva.viewModel.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.database.Entity.TrainingEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.DietRepository
import com.prueba.aplicaciondeportiva.database.Repository.TrainingRepository
import com.prueba.aplicaciondeportiva.ui.nutrition.DietsFragmentDirections
import com.prueba.aplicaciondeportiva.ui.training.TrainingFragmentDirections
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.prefab_diet.view.*
import kotlinx.android.synthetic.main.prefab_training.view.*
import kotlinx.coroutines.launch
import java.lang.Exception

class TrainingViewModel : ViewModel(){

    //region events
    fun navigateToTrainings(view : View){
        val action = TrainingFragmentDirections.action_navigation_training_to_trainingsFragment()
        view.findNavController().navigate(action)
    }
    //endregion
}