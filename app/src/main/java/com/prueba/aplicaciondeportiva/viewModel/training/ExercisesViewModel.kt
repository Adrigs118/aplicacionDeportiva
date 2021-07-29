package com.prueba.aplicaciondeportiva.viewModel.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.database.Entity.ExerciseEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.DietRepository
import com.prueba.aplicaciondeportiva.database.Repository.ExerciseRepository
import com.prueba.aplicaciondeportiva.ui.training.ExercisePartFragmentDirections
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlinx.android.synthetic.main.fragment_diet_edit.*
import kotlinx.android.synthetic.main.prefab_exercise.view.*

class ExercisesViewModel : ViewModel(){

    //region variables
    val repository = ExerciseRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.exerciseDao())
    val all = repository.exercises
    //endregion

    //region events
    fun navigateToDescription(view : View){
        val action = ExercisePartFragmentDirections.action_exercisePartFragment_to_exerciseDialogFragment()
        view.findNavController().navigate(action)
    }
    //endregion

    //region funcs
    fun getAllDietsObservers() : LiveData<List<ExerciseEntity>> {
        return all
    }
    //endregion

    //region RecyclerViewAdapter InnerClass
    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        var items : ArrayList<ExerciseEntity> = ArrayList<ExerciseEntity>()

        fun setListData(data: ArrayList<ExerciseEntity>) {
            this.items = data
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.prefab_exercise, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(items[position])
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val textViewName = itemView.textView_prefab_training_title
            val textViewdescription = itemView.textView_exercise_tag

            fun bind(data: ExerciseEntity) {
                textViewName.text = data.name
                textViewdescription.text = data.tag
            }

            init {
                itemView.setOnClickListener {
                    Utils.exerciseContext = all.value!![position]
                    navigateToDescription(itemView)
                }
            }
        }

    }
    //endregion



}