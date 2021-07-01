package com.prueba.aplicaciondeportiva.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        card_nutrition.setOnClickListener {
            viewModel.navigateToNutrition(view)
        }

        card_strechting.setOnClickListener {
            viewModel.navigateToStretchting(view)
        }

        card_training.setOnClickListener {
            viewModel.navigateToTraining(view)
        }

        card_weight.setOnClickListener {
            viewModel.navigateToWeight(view)
        }
    }
}