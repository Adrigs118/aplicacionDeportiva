package com.prueba.aplicaciondeportiva.viewModel.training

import android.graphics.Color
import android.graphics.drawable.Drawable
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
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.prefab_diet.view.*
import kotlinx.android.synthetic.main.prefab_training.view.*
import kotlinx.coroutines.launch
import okhttp3.internal.Util
import java.lang.Exception

class TrainingsViewModel : ViewModel(){

    val repository = TrainingRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.trainingDao())
    val items = repository.trainings

    //region events
    fun navigateToDescription(view : View){
        val action = DietsFragmentDirections.action_dietsFragment_to_dietFragment()
        view.findNavController().navigate(action)
    }
    //endregion

    fun getAllDietsObservers() : LiveData<List<TrainingEntity>> {
        return items
    }

    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        var items : ArrayList<TrainingEntity> = ArrayList<TrainingEntity>()

        fun setListData(data: ArrayList<TrainingEntity>) {
            this.items = data
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.prefab_training, parent, false)
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
            val textViewDif = itemView.textView_train_dif
            val textViewDays = itemView.textView_train_days
            val textViewType = itemView.textView_train_type

            fun bind(data: TrainingEntity) {
                textViewName.text = data.name
                textViewDif.text = difToString(data.difficult)
                textViewDif.setBackgroundColor(difColor(data.difficult))
                textViewDays.text = data.days.toString() + " " + Utils.getStringByIdName(Utils.getApplicationContext(), "days")
                textViewType.text = data.target
            }

            fun difToString(dif : Int) : String{
                if (dif == 1) return Utils.getStringByIdName(Utils.getApplicationContext(), "easy")
                else if (dif == 2) return Utils.getStringByIdName(Utils.getApplicationContext(), "medium")
                else return Utils.getStringByIdName(Utils.getApplicationContext(), "hard")
            }

            fun difColor(dif : Int) : Int{
                if (dif == 1) return Color.GREEN
                else if (dif == 2) return Color.YELLOW
                else return Color.RED
            }

            //init {
                /*itemView.setOnClickListener {
                    Utils.setTrainingContext(items!![position])
                    navigateToDescription(itemView)
                }*/

            //}
        }

    }







}