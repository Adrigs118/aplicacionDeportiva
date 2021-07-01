package com.prueba.aplicaciondeportiva.viewModel.Weight

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjoe64.graphview.DefaultLabelFormatter
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.Viewport
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Dao.BodyDao
import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.BodyRepository
import com.prueba.aplicaciondeportiva.utils.DialogAux
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow

class WeightViewModel :ViewModel() {

    val repository = BodyRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.bodyDao())
    lateinit var body : List<BodyEntity>
    var gender : Boolean = true

    fun insert(entity : BodyEntity){
            viewModelScope.launch {
                repository.insert(entity)
            }
    }

    fun update(entity : BodyEntity){
        viewModelScope.launch {
            repository.update(entity)
        }
    }

    fun checkFields(fm :FragmentManager, warning : String, warning2: String) :Boolean{
        if(body != null){
            if (body!!.get(0).weight == 0.0F || body!![0].height == 0){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, warning, false)
                dialog.show(fm, "warningDialog")
                return false
            }
            else if (body!![0].weight < 20.0 || body!![0].weight > 350.0 ||
                    body!![0].height < 60 || body!![0].height > 240){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, warning2, false)
                dialog.show(fm, "warningDialog")
                return false
            }
        }
        else {
            val dialog = DialogAux(DialogAux.TypeDialog.WARNING, warning, false)
            dialog.show(fm, "warningDialog")
            return false
        }
        return true
    }

    fun setGender(tb : TextView, image : ImageView){
        if (gender){
            image.setImageResource(R.mipmap.face_head_female_woman_icon_143234)
            tb.text = getString(Utils.getApplicationContext(),"female")
            gender = false
        }
        else{
            image.setImageResource(R.mipmap.face_male_human_body_icon_143216)
            tb.text = getString(Utils.getApplicationContext(),"male")
            gender = true
        }
        val updateGender = BodyEntity(0, gender, body[0].age, body[0].weight, body[0].height,
            body[0].imc)

        update(updateGender)

    }

    fun initFields(tb : TextView, image: ImageView){
        viewModelScope.launch {
            body = repository.getAll()
            gender = body[0].gender
            if(gender){
                image.setImageResource(R.mipmap.face_male_human_body_icon_143216)
                tb.text = getString(Utils.getApplicationContext(),"male")
            }
            else{
                image.setImageResource(R.mipmap.face_head_female_woman_icon_143234)
                tb.text = getString(Utils.getApplicationContext(),"female")
            }
        }
    }

    fun addImc(graph: GraphView, weight: String, height: String){

        val series : LineGraphSeries<DataPoint> = LineGraphSeries()
        val y : Double = (weight.toDouble() / (height.toDouble() /100).pow(2))
        series.appendData(DataPoint(Date(),y), true, 5)
        graph.addSeries(series)
        graph.title = "Imc : " + String.format("%.2f", y)
    }

    fun initGraph(graph : GraphView){

        val series : LineGraphSeries<DataPoint> = LineGraphSeries()

        graph.getGridLabelRenderer().setLabelFormatter(object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                if (isValueX) {
                    val formatter = SimpleDateFormat("MM-dd HH:mm")
                    return formatter.format(value)
                }
                return super.formatLabel(value, isValueX)
            }
        })

        graph.viewport.isXAxisBoundsManual = true
        graph.getGridLabelRenderer().numHorizontalLabels = 2
        graph.viewport.xAxisBoundsStatus = Viewport.AxisBoundsStatus.FIX
        //graph.viewport.setMaxX((cal2.time.toDouble()))

        series.color = Color.RED
        series.title = "Imc"
        series.isDrawDataPoints = true
        graph.titleTextSize = 60.0F
        graph.titleColor = Color.WHITE
    }

    fun getString(context: Context, idName: String): String {
        val res = context.getResources()
        return res.getString(res.getIdentifier(idName, "string", context.getPackageName()))
    }

    enum class Genre { MALE, FEMALE}


}