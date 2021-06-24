package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prueba.aplicaciondeportiva.Diet
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.Utils
import kotlinx.android.synthetic.main.fragment_diets.*

class DietsFragment : Fragment() {

    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_diets, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dietsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter()
        }
    }

    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        var diets : MutableList<Diet> =  initDietsCollection()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.prefab_diet, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return diets.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = diets.get(position).getName()
            holder.description.text = diets.get(position).getDescription()
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var name: TextView
            var description: TextView

            init {
                name = itemView.findViewById(R.id.chestS_name)
                description = itemView.findViewById(R.id.diet_desc)

                itemView.setOnClickListener {
                    Utils.setDietContext(diets.get(position))
                    val action = DietsFragmentDirections.action_dietsFragment_to_dietFragment()
                    findNavController().navigate(action)
                }
            }
        }

        private fun initDietsCollection() : MutableList<Diet>{

                var list :MutableList<Diet> = mutableListOf()

                val diet1 : Diet = Diet("Flexitariana", "Dieta con poca carne",
                    Diet.DayDiet("Tortitas de arroz con crema choco industrial", "", "Arroz blanco", "", "Seitán"),
                    Diet.DayDiet("Pan de semillas (hecho con harina blanca)", "", "El buen plato de garbanzos", "", "Soja texturizada"),
                    Diet.DayDiet("Copos de avena con leche", "", "Hamburguesa de soja", "", "Garbanzos"),
                    Diet.DayDiet("Galletas veganas con leche", "", "El buen plato de lentejas", "", "Seitán"),
                    Diet.DayDiet("Tostadas o biscotes", "", "Tofu con vegetales", "", "Huevo"),
                    Diet.DayDiet("Bizcocho fit", "", "Hamburguesa de seitán", "", "Gambas de soja"),
                    Diet.DayDiet("Tortitas de arroz", "", "Pescado", "", "Tofu"))

                list.add(diet1)

                val diet2 : Diet = Diet("Proteíca", "Alta en proteinas",
                    Diet.DayDiet("Vaso de leche con cacao y galletas integrales", "Frutas troceadas con muesli y Mini BabyBel (1 unidad)",
                        "Menestra de verduras, Filete de ternera con patatas fritas y manzana", "Bocadillo de atún",
                        "Guisantes salteados con jamón, tortilla francesa con tomate aliñado y Mini Babybel, mandarinas"),
                    Diet.DayDiet("Vaso de leche con cacao y tostadas con queso fresco", "Bocadillo de jamón de york",
                        "Macarrones a la boloñesa, rodajas de merluza con ensalada y plátano", "Macedonia de frutas con MiniBabybel (2)",
                        "Puré de calabacín, Pollo rebozado con alcachofas, yogurt"),
                    Diet.DayDiet("Vaso de leche con cacao y cereales", "Mini bocadillos con Babybel(1)",
                        "Arroz a la milanesa, Tortilla de verduras con queso, pera en almibar", "Yogurt y zumo de frutas",
                        "Sopa de ave con fideos, sepia a la plancha con ensalada y yogurt"),
                    Diet.DayDiet("Vaso de leche con cacao y tostadas con jamón", "Sandwich vegetal",
                        "Potaje de lentejas, conejo al horno con zanahoria baby, yogurt", "Brocheta de frutas con queso",
                        "Judías con patatas, huevos fritos con ensalada y naranja"),
                    Diet.DayDiet("Vaso de leche y cereales de desayuno", "MiniBabybel(1) y zomo de frutas",
                        "Arroz salteado con verduras, salmón a la plancha con espárragos trigueros, uvas", "Yogurt con cereales con desayuno",
                        "Patata gratinada con queso y jamón, muslitos de pollo con tomate aliñado, mandarinas"),
                    Diet.DayDiet("Vaso de leche con cacao y tostadas con mermelada", "Yogurt con fresas",
                        "Canelones de espinacas, albóndigas a la jardinera, manzana asada", "Sandwich de jamón y queso",
                        "Ensaladilla rusa, buñuelos de bacalao con champiñones salteados, yogurt"),
                    Diet.DayDiet("Vaso de leche con cacao y tostadas y mermelada", "Zumo de frutas",
                        "Paella de pescado y marisco, bacalao con ensalada, piña en almibar", "Bocadillo de atún",
                        "Sopa de ave con fideos, brochetas de pollo con pimiento y tomate, yogurt"))

                list.add(diet2)

            return list
        }
    }
}



