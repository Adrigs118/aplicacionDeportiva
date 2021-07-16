package com.prueba.aplicaciondeportiva.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.training.TrainingViewModel
import com.prueba.aplicaciondeportiva.viewModel.training.TrainingsViewModel
import kotlinx.android.synthetic.main.fragment_diets.*
import kotlinx.android.synthetic.main.fragment_training.*

class TrainingFragment : Fragment(){

    private lateinit var viewModel: TrainingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_training, container, false)
        viewModel = ViewModelProviders.of(this).get(TrainingViewModel::class.java)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_trainings.setOnClickListener {
            viewModel.navigateToTrainings(view)
        }

    }
}