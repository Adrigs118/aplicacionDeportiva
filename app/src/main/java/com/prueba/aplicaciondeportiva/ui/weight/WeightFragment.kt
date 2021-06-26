package com.prueba.aplicaciondeportiva.ui.weight

import android.graphics.Color
import android.os.Bundle
import android.service.autofill.FieldClassification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jjoe64.graphview.DefaultLabelFormatter
import com.jjoe64.graphview.Viewport
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.prueba.aplicaciondeportiva.Body
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.ui.home.HomeFragmentDirections
import com.prueba.aplicaciondeportiva.utils.DialogAux
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_weight.*
import kotlin.math.sin

import java.text.SimpleDateFormat
import java.util.*


class WeightFragment : Fragment(){

    //region variables
    private var body = Body()
    //endregion

    //region eventos
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_weight, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_imc.setOnClickListener {
            if (body.getAge() == null || body.getWeight() == null || body.getHeight() == null){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, "Debes introducir todos los datos para continuar", false)
                dialog.show(childFragmentManager, "warningDialog")
            }
        }

        //region imcGraph
        val series :LineGraphSeries<DataPoint> = LineGraphSeries()
        val cal : Date = Date()
        val cal2 : Date = Date()
            //GregorianCalendar(2021,6,25,12,0,0)
        //val sdf = SimpleDateFormat("dd/M/yyyy")
        //val currentTime =sdf.format(Date())
        var y : Double

        for (x in 1..2){
            //y = sin(2*x*0.2) - 2* sin(x*0.2)
            when (x) {
                1 -> {y = 38.0; series.appendData(DataPoint(cal,y), true, 2)}
                2 -> {y = 32.6; series.appendData(DataPoint(cal2,y), true, 2)}
            }
        }

        graph.getGridLabelRenderer().setLabelFormatter(object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                if (isValueX) {
                    val formatter = SimpleDateFormat("MM-dd HH:mm")
                    return formatter.format(value)
                }
                return super.formatLabel(value, isValueX)
            }
        })

        graph.addSeries(series)
        graph.viewport.isXAxisBoundsManual = true
        //graph.viewport.setMinX(cal.time.toDouble())
        graph.getGridLabelRenderer().numHorizontalLabels = 2
        graph.viewport.xAxisBoundsStatus = Viewport.AxisBoundsStatus.FIX
        graph.viewport.setMaxX((cal2.time.toDouble()))

        series.color = Color.RED
        series.title = "Imc"
        series.isDrawDataPoints = true
        graph.title = "Imc  17.4"
        graph.titleTextSize = 60.0F
        graph.titleColor = Color.WHITE
        //endregion
    }

    //endregion
}