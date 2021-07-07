package com.prueba.aplicaciondeportiva.ui.stretchting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.Strechting.StrechtingViewModel
import kotlinx.android.synthetic.main.fragment_stretchting.*

class StretchtingFragment : Fragment(){

    private lateinit var viewModel: StrechtingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_stretchting, container, false)
        viewModel = ViewModelProviders.of(this).get(StrechtingViewModel::class.java)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_chest.setOnClickListener {
            viewModel.navigate(view,"CHEST")
        }

        card_back.setOnClickListener {
            viewModel.navigate(view,"BACK")
        }

        card_biceps.setOnClickListener {
            viewModel.navigate(view,"BICEP")
        }

        card_triceps.setOnClickListener {
            viewModel.navigate(view,"TRICEP")
        }

        card_shoulder.setOnClickListener {
            viewModel.navigate(view,"SHOULDER")
        }

        card_abs.setOnClickListener {
            viewModel.navigate(view,"ABS")
        }

        card_frontLeg.setOnClickListener {
            viewModel.navigate(view,"FRONTLEG")
        }

        card_backLeg.setOnClickListener {
            viewModel.navigate(view,"BACKLEG")
        }
    }
}