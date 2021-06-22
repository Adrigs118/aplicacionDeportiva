package com.prueba.aplicaciondeportiva.ui.nutrition

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prueba.aplicaciondeportiva.R
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

        private val nombres = arrayOf(
            "Flexitariana", "Cetogenica o keto", "Mediterranea", "Verano",
            "Proteíca", "1800Kcal"

        )

        private val descripciones = arrayOf(
            "Dieta con poca carne", "Perder peso poco a poco","La más saludable", "Dieta para verano",
            "Alta en proteinas", "Dieta de 1800kcal"
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.prefab_diet, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return nombres.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = nombres[position]
            holder.description.text = descripciones[position]
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var name: TextView
            var description: TextView

            init {
                name = itemView.findViewById(R.id.diet_name)
                description = itemView.findViewById(R.id.diet_desc)

                itemView.setOnClickListener {
                    //var position: Int = getAdapterPosition()
                    val action = DietsFragmentDirections.action_dietsFragment_to_dietFragment().setNAME(name.text.toString())
                    findNavController().navigate(action)
                }
            }
        }
    }
}



