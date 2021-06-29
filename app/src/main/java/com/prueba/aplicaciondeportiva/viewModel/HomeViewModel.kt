package com.prueba.aplicaciondeportiva.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.prueba.aplicaciondeportiva.ui.home.HomeFragmentDirections

class HomeViewModel : ViewModel(){

    fun navigateToStretchting(view : View){
        val action = HomeFragmentDirections.action_navigation_home_to_navigation_stretchting()
        view.findNavController().navigate(action)
    }

    fun navigateToNutrition(view : View){
        val action = HomeFragmentDirections.action_navigation_home_to_navigation_nutrition()
        view.findNavController().navigate(action)
    }

    fun navigateToWeight(view : View){
        val action = HomeFragmentDirections.action_navigation_home_to_navigation_weight()
        view.findNavController().navigate(action)
    }

    fun navigateToTraining(view : View){
        val action = HomeFragmentDirections.action_navigation_home_to_navigation_training()
        view.findNavController().navigate(action)
    }
}