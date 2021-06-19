package com.prueba.aplicaciondeportiva.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        nutritionButton.setOnClickListener {
            val action = HomeFragmentDirections.action_navigation_home_to_navigation_nutrition()
            findNavController().navigate(action)
        }

        stretchingButton.setOnClickListener {
            val action = HomeFragmentDirections.action_navigation_home_to_navigation_stretchting()
            findNavController().navigate(action)
        }

        trainingPlansButton.setOnClickListener {
            val action = HomeFragmentDirections.action_navigation_home_to_navigation_training()
            findNavController().navigate(action)
        }

        weightButton.setOnClickListener {
            val action = HomeFragmentDirections.action_navigation_home_to_navigation_weight()
            findNavController().navigate(action)
        }
    }
}