package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.nutrition.NutritionViewModel
import kotlinx.android.synthetic.main.fragment_nutrition.*

class NutritionFragment : Fragment(){

    private lateinit var viewModel: NutritionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(NutritionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_nutrition, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_diets.setOnClickListener {
            viewModel.navToDiets(view)
        }

        card_calories.setOnClickListener {
            viewModel.navToCalories(view)
        }
    }
}