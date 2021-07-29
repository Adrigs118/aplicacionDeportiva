package com.prueba.aplicaciondeportiva.viewModel.training

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.marginBottom
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.ExerciseEntity
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity
import com.prueba.aplicaciondeportiva.database.Entity.TrainingEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.ExerciseRepository
import com.prueba.aplicaciondeportiva.database.Repository.StrechtingRepository
import com.prueba.aplicaciondeportiva.database.Repository.TrainingRepository
import com.prueba.aplicaciondeportiva.ui.training.TrainingExampleFragmentDirections
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.fragment_stretchting_description.*
import kotlinx.coroutines.launch
import java.lang.Exception

class TrainingExampleViewModel : ViewModel() {

    val repository = TrainingRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.trainingDao())
    var entity : TrainingEntity? = Utils.trainingContext
    val repository2 = ExerciseRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.exerciseDao())
    val all = repository2.exercises

    fun initTexts(days : TextView, diff : TextView, tag : TextView, title : TextView, description : TextView){
        days.text = entity!!.days.toString() + " " + Utils.getStringByIdName(Utils.getApplicationContext(),"days")
        description.text = entity!!.description
        title.text = entity!!.name
        diff.text = difToString(entity!!.difficult)
        tag.text = entity!!.target
    }

    fun difToString(dif : Int) : String{
        if (dif == 1) return Utils.getStringByIdName(Utils.getApplicationContext(), "easy")
        else if (dif == 2) return Utils.getStringByIdName(Utils.getApplicationContext(), "medium")
        else return Utils.getStringByIdName(Utils.getApplicationContext(), "hard")
    }

    fun addDays(layout : LinearLayout, context : Context, view: View){
        for(i in 1..entity!!.days){
            addDayCard(i, layout, context, view)
        }
    }

    fun navigationToExercise(view : View){
        Utils.exerciseContext =  ExerciseEntity(0, "Elevación de rodillas colgando", "Realizar un movimiento lateral inclinando el tronco de lado a lado, tetornando a la posición inicial luego de cada inclinación.",
            1, 1, 1.0F, "Hipertrofia")
        val action = TrainingExampleFragmentDirections.action_trainingExampleFragment_to_exerciseDialogFragment()
        view.findNavController().navigate(action)
    }

    @SuppressLint("ResourceAsColor")
    fun addDayCard(i : Int, layout : LinearLayout, context : Context, view: View){
        val cardView = CardView(context)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(20,10,20,10)
        val params2 = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        val cardLinearLayout = LinearLayout(context)

        cardLinearLayout.orientation = LinearLayout.VERTICAL
        cardView.radius = 15f
        cardView.setCardBackgroundColor(Color.parseColor("#009688"))
        cardView.setContentPadding(10,10,10,10)
        cardView.layoutParams = params
        cardView.cardElevation = 10f

        val title = TextView(context)
        if (i == 1) title.text = Utils.getStringByIdName(Utils.getApplicationContext(),"monday")
        if (i == 2) title.text = Utils.getStringByIdName(Utils.getApplicationContext(),"wednesday")
        if (i == 3) title.text = Utils.getStringByIdName(Utils.getApplicationContext(),"friday")
        title.textSize = 20f
        title.setTextColor(Color.WHITE)
        title.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD)

        val exercise = TextView(context)
        exercise.text = "Elevación de rodillas colgando (2 series 10 repeticiones)"
        exercise.textSize = 16f
        exercise.setTextColor(Color.BLACK)
        exercise.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL)
        exercise.visibility = View.GONE
        exercise.setBackgroundColor(Color.parseColor("#ccffdd"))
        exercise.setOnClickListener{
            navigationToExercise(view)
        }


        val exercise2 = TextView(context)
        exercise2.text = "Elevación de rodillas colgando (3 series 12 repeticiones)"
        exercise2.textSize = 16f
        exercise2.setTextColor(Color.BLACK)
        exercise2.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL)
        exercise2.visibility = View.GONE
        exercise2.setBackgroundColor(Color.parseColor("#ccffdd"))
        exercise2.setOnClickListener {
            navigationToExercise(view)
        }

        cardLinearLayout.addView(title)
        cardLinearLayout.addView(exercise)
        if (i == 2) cardLinearLayout.addView(exercise2)
        cardView.addView(cardLinearLayout)
        layout.addView(cardView)

        cardView.setOnClickListener{
            val layout = cardView.getChildAt(0) as LinearLayout
            for(x in 1..layout.childCount - 1){
                val aux = layout.getChildAt(x) as TextView
                if( aux.visibility == View.GONE) aux.visibility = View.VISIBLE
                else aux.visibility = View.GONE
            }
        }
    }

    fun update(entity : StrechtingEntity) :Boolean{
        try{
            viewModelScope.launch {
               // repository.update(entity)
            }
            return true
        }
        catch (e :Exception){
            return false
        }
    }
}