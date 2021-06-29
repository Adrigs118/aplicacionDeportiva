package com.prueba.aplicaciondeportiva.viewModel.nutrition

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.DietRepository
import com.prueba.aplicaciondeportiva.ui.nutrition.DietsFragmentDirections
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.prefab_diet.view.*
import kotlinx.coroutines.launch

class DietsViewModel : ViewModel(){

    val repository = DietRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.dietDao())
    val allDiets = repository.diets

    //region events
    fun navigateToEdit(view : View, tipo : String){
        val action = DietsFragmentDirections.action_dietsFragment_to_dietEditFragment(tipo)
        view.findNavController().navigate(action)
    }

    fun navigateToDescription(view : View){
        val action = DietsFragmentDirections.action_dietsFragment_to_dietFragment()
        view.findNavController().navigate(action)
    }
    //endregion

    fun getAllDietsObservers() : LiveData<List<DietWithDay>> {
        return allDiets
    }

    //region Database functions

    fun existName(name : String) :Boolean{
        for(diet in allDiets.value!!){
            if(diet.diet.name == name) return true
        }
        return false
    }

    fun insert(entity : DietWithDay) {
        viewModelScope.launch {
            repository.insert(entity)
        }
    }

    fun delete(entity : DietWithDay) {
        viewModelScope.launch {
            repository.delete(entity)
        }
    }

    fun updateDiet(entity : DietWithDay) {
        viewModelScope.launch {
            repository.update(entity)
        }
    }
    //endregion

    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        var items : ArrayList<DietWithDay> = ArrayList<DietWithDay>()

        fun setListData(data: ArrayList<DietWithDay>) {
            this.items = data
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.prefab_diet, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(items[position])
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val textViewName = itemView.textView_diet_name
            val textViewdescription = itemView.diet_desc

            fun bind(data: DietWithDay) {
                textViewName.text = data.diet.name
                textViewdescription.text = data.diet.description
            }

            init {
                itemView.setOnClickListener {
                    Utils.setDietContext(allDiets.value!![position])
                    navigateToDescription(itemView)
                }

                itemView.setOnLongClickListener(object : View.OnLongClickListener {
                    override fun onLongClick(v: View?): Boolean {
                        Utils.setDietContext(allDiets.value!![position])
                        navigateToEdit(v!!, "EDIT")
                        return false
                    }
                })
            }
        }

    }







}