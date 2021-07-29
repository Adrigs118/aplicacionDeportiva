package com.prueba.aplicaciondeportiva.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.Strechting.StrechtingPartViewModel
import com.prueba.aplicaciondeportiva.viewModel.Strechting.StrechtingViewModel
import com.prueba.aplicaciondeportiva.viewModel.training.ExercisesViewModel
import kotlinx.android.synthetic.main.fragment_exercises.*
import kotlinx.android.synthetic.main.fragment_stretchting.card_chest
import kotlinx.android.synthetic.main.fragment_stretchting_part.*

class ExercisePartFragment : Fragment(){

    private lateinit var viewModel: ExercisesViewModel
    private lateinit var recyclerViewAdapter: ExercisesViewModel.RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_exercises, container, false)
        viewModel = ViewModelProviders.of(this).get(ExercisesViewModel::class.java)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val act : MainActivity = activity as MainActivity
        act.setActionBarTitle("Ejercicios de abdomen")

        exerciseRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            recyclerViewAdapter = viewModel.RecyclerAdapter()
            adapter = recyclerViewAdapter
        }

        button.setOnClickListener {
           ///
        }

        viewModel.getAllDietsObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
    }
}