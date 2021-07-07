package com.prueba.aplicaciondeportiva.viewModel.Strechting

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.StrechtingRepository
import com.prueba.aplicaciondeportiva.ui.stretchting.StretchtingPartFragmentDirections
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.coroutines.launch
import java.lang.Exception

class StrechtingPartViewModel : ViewModel(){

    val repository = StrechtingRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.strechtingDao())

    fun navigate(view : View){
        pass(view)

    }

    fun pass(view : View){
        try{
            viewModelScope.launch {
                Utils.strechtingContext = repository.getById(0)
                val action = StretchtingPartFragmentDirections.action_stretchtingPartFragment_to_stretchtingDialogFragment()
                view.findNavController().navigate(action)
            }
        }
        catch (e : Exception){
        }
    }
}