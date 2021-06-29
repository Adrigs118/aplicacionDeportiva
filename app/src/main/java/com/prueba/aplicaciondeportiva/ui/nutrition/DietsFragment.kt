package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.prueba.aplicaciondeportiva.R
import kotlinx.android.synthetic.main.fragment_diets.*

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.database.Entity.DietDayEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.viewModel.nutrition.DietsViewModel


class DietsFragment : Fragment() {

    private lateinit var viewModel: DietsViewModel
    private lateinit var recyclerViewAdapter: DietsViewModel.RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(DietsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_diets, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dietsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            recyclerViewAdapter = viewModel.RecyclerAdapter()
            adapter = recyclerViewAdapter
        }

        imageViewPlus.setOnClickListener {
            viewModel.navigateToEdit(view, "NUEVO")
        }

        viewModel.getAllDietsObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })

        val diet = DietWithDay()
        diet.diet = DietEntity("Flexitariana", "Dieta con poca carne", "Prueba")
        diet.days = listOf(
            DietDayEntity("monday", "Flexitariana", "Tortitas de arroz con crema choco industrial","", "Arroz blanco", "", "Seitán"),
            DietDayEntity("tuesday", "Flexitariana", "Pan de semillas (hecho con harina blanca)", "", "El buen plato de garbanzos", "", "Soja texturizada"),
            DietDayEntity("wednesday", "Flexitariana", "Copos de avena con leche", "", "Hamburguesa de soja", "", "Garbanzos"),
            DietDayEntity("thursday", "Flexitariana", "Galletas veganas con leche", "", "El buen plato de lentejas", "", "Seitán"),
            DietDayEntity("friday", "Flexitariana", "Tostadas o biscotes", "", "Tofu con vegetales", "", "Huevo"),
            DietDayEntity("saturday", "Flexitariana", "Bizcocho fit", "", "Hamburguesa de seitán", "", "Gambas de soja"),
            DietDayEntity("sunday", "Flexitariana", "Tortitas de arroz", "", "Pescado", "", "Tofu"))


        val diet2 = DietWithDay()
        diet2.diet = DietEntity("Proteica", "Alta en proteinas", "Prueba")
        diet2.days = listOf(
            DietDayEntity("monday", "Proteica", "Vaso de leche con cacao y galletas integrales", "Frutas troceadas con muesli y Mini BabyBel (1 unidad)",
                "Menestra de verduras, Filete de ternera con patatas fritas y manzana", "Bocadillo de atún",
                "Guisantes salteados con jamón, tortilla francesa con tomate aliñado y Mini Babybel, mandarinas"),
            DietDayEntity("tuesday", "Proteica", "Vaso de leche con cacao y tostadas con queso fresco", "Bocadillo de jamón de york",
                "Macarrones a la boloñesa, rodajas de merluza con ensalada y plátano", "Macedonia de frutas con MiniBabybel (2)",
                "Puré de calabacín, Pollo rebozado con alcachofas, yogurt"),
            DietDayEntity("wednesday", "Proteica", "Vaso de leche con cacao y cereales", "Mini bocadillos con Babybel(1)",
                "Arroz a la milanesa, Tortilla de verduras con queso, pera en almibar", "Yogurt y zumo de frutas",
                "Sopa de ave con fideos, sepia a la plancha con ensalada y yogurt"),
            DietDayEntity("thursday", "Proteica", "Vaso de leche con cacao y tostadas con jamón", "Sandwich vegetal",
                "Potaje de lentejas, conejo al horno con zanahoria baby, yogurt", "Brocheta de frutas con queso",
                "Judías con patatas, huevos fritos con ensalada y naranja"),
            DietDayEntity("friday", "Proteica", "Vaso de leche y cereales de desayuno", "MiniBabybel(1) y zomo de frutas",
                "Arroz salteado con verduras, salmón a la plancha con espárragos trigueros, uvas", "Yogurt con cereales con desayuno",
                "Patata gratinada con queso y jamón, muslitos de pollo con tomate aliñado, mandarinas"),
            DietDayEntity("saturday", "Proteica", "Vaso de leche con cacao y tostadas con mermelada", "Yogurt con fresas",
                "Canelones de espinacas, albóndigas a la jardinera, manzana asada", "Sandwich de jamón y queso",
                "Ensaladilla rusa, buñuelos de bacalao con champiñones salteados, yogurt"),
            DietDayEntity("sunday", "Proteica", "Vaso de leche con cacao y tostadas y mermelada", "Zumo de frutas",
                "Paella de pescado y marisco, bacalao con ensalada, piña en almibar", "Bocadillo de atún",
                "Sopa de ave con fideos, brochetas de pollo con pimiento y tomate, yogurt"))

        //viewModel.insert(diet2)

        println("PRUEBAAAAAAAAAAA" + viewModel.allDiets.toString())
    }

}



