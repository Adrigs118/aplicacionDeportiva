package com.prueba.aplicaciondeportiva.viewModel.nutrition

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.prueba.aplicaciondeportiva.ui.nutrition.NutritionFragmentDirections

class NutritionViewModel : ViewModel(){

    fun navToDiets(view : View){
        val action = NutritionFragmentDirections.action_navigation_nutrition_to_dietsFragment()
        view.findNavController().navigate(action)
    }
}