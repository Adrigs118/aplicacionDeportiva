package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.prueba.aplicaciondeportiva.R
import kotlinx.android.synthetic.main.fragment_diets.*

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.database.Entity.DietDayEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.viewModel.nutrition.DietsViewModel


class DietsFragment : Fragment() {

    private lateinit var viewModel: DietsViewModel
    private lateinit var recyclerViewAdapter: DietsViewModel.RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(DietsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_diets, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dietsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            recyclerViewAdapter = viewModel.RecyclerAdapter()
            adapter = recyclerViewAdapter
        }

        imageViewPlus.setOnClickListener {
            viewModel.navigateToEdit(view, "NUEVO")
        }

        viewModel.getAllDietsObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
    }

}



