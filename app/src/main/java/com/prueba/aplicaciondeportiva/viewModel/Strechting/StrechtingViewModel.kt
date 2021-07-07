package com.prueba.aplicaciondeportiva.viewModel.Strechting

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.prueba.aplicaciondeportiva.ui.stretchting.StretchtingFragmentDirections

class StrechtingViewModel : ViewModel() {

    fun navigate(view : View, tag: String){
        val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("CHEST")
        view.findNavController().navigate(action)
    }

}