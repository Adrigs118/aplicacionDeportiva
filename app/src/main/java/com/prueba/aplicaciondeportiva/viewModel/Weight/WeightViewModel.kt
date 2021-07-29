package com.prueba.aplicaciondeportiva.viewModel.Weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.widget.EditText
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
import java.time.LocalDate
import java.time.LocalDateTime
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

    fun checkFields(fm :FragmentManager, warning : String, warning2: String, height : EditText, weight: EditText) :Boolean{
            if (weight.text.toString().toFloat() == 0.0F || height.text.toString().toInt() == 0){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, warning, false)
                dialog.show(fm, "warningDialog")
                return false
            }
            else if (weight.text.toString().toFloat() < 20.0 || weight.text.toString().toFloat() > 350.0 ||
                height.text.toString().toInt() < 60 || height.text.toString().toInt() > 240){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, warning2, false)
                dialog.show(fm, "warningDialog")
                return false
            }
            else return true
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

    fun initFields(tb : TextView, image: ImageView, edweight : EditText,
                   edheight : EditText, edage : EditText, graph : GraphView){
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
            if( body[0].weight != 0.0F)edweight.setText(body[0].weight.toString())
            if( body[0].height != 0)edheight.setText(body[0].height.toString())
            if( body[0].age != 0)edage.setText(body[0].age.toString())
            if( body[0].imc != 0.0) graph.title = "Imc : " + String.format("%.2f", body[0].imc)
        }
    }

    @SuppressLint("NewApi")
    fun addImc(graph: GraphView, height: String, weight: String){

        val y : Double = (weight.toDouble() / (height.toDouble() /100).pow(2))
        val date = Date().time

        (graph.series[0] as LineGraphSeries<DataPoint>).appendData(DataPoint(Date(date), y - 7), true, 5)
        graph.title = "Imc : " + String.format("%.2f", y)
        body[0].imc = y
        update(body[0])
    }

    fun initGraph(graph : GraphView){

        val series : LineGraphSeries<DataPoint> = LineGraphSeries()

        series.color = Color.RED
        series.title = "Imc"
        series.isDrawDataPoints = true

        val dateAuxpre = (Date().time )- 1000000000
        val dateAuxpre2 = (Date().time ) - 500000000

        series.appendData(DataPoint(Date(dateAuxpre),20.0), true, 5)
        series.appendData(DataPoint(Date(dateAuxpre2),25.0), true, 5)
        graph.addSeries(series)

        graph.title = "Imc : " + String.format("%.2f", 25.0)

        graph.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                if (isValueX) {
                    val formatter = SimpleDateFormat("MM-dd")
                    return formatter.format(value)
                }
                return super.formatLabel(value, isValueX)
            }
        }

        graph.viewport.isXAxisBoundsManual = true
        graph.gridLabelRenderer.numHorizontalLabels = 3
        graph.viewport.xAxisBoundsStatus = Viewport.AxisBoundsStatus.FIX

        graph.titleTextSize = 60.0F
        graph.titleColor = Color.WHITE
        graph.viewport.isScalable = false
        graph.viewport.isScrollable = true
    }

    fun getString(context: Context, idName: String): String {
        val res = context.resources
        return res.getString(res.getIdentifier(idName, "string", context.packageName))
    }
}