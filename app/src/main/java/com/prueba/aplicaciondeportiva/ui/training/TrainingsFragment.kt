package com.prueba.aplicaciondeportiva.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.training.TrainingsViewModel
import kotlinx.android.synthetic.main.fragment_trainings.*

class TrainingsFragment : Fragment(){

    private lateinit var viewModel: TrainingsViewModel
    private lateinit var recyclerViewAdapter: TrainingsViewModel.RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_trainings, container, false)
        viewModel = ViewModelProviders.of(this).get(TrainingsViewModel::class.java)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trainingsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            recyclerViewAdapter = viewModel.RecyclerAdapter()
            adapter = recyclerViewAdapter
        }

        viewModel.getAllDietsObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
    }
}