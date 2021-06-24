package com.prueba.aplicaciondeportiva.ui.stretchting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.R
import kotlinx.android.synthetic.main.fragment_stretchting.*

class StretchtingFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_stretchting, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_chest.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("CHEST")
            findNavController().navigate(action)
        }

        card_back.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("BACK")
            findNavController().navigate(action)
        }

        card_biceps.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("BICEP")
            findNavController().navigate(action)
        }

        card_triceps.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("TRICEP")
            findNavController().navigate(action)
        }

        card_shoulder.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("SHOULDER")
            findNavController().navigate(action)
        }

        card_abs.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("ABS")
            findNavController().navigate(action)
        }

        card_frontLeg.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("FRONTLEG")
            findNavController().navigate(action)
        }

        card_backLeg.setOnClickListener {
            val action = StretchtingFragmentDirections.action_navigation_stretchting_to_stretchtingPartFragment("BACKLEG")
            findNavController().navigate(action)
        }
    }
}