package com.prueba.aplicaciondeportiva.ui.stretchting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.Strechting.StrechtingPartViewModel
import com.prueba.aplicaciondeportiva.viewModel.Strechting.StrechtingViewModel
import kotlinx.android.synthetic.main.fragment_stretchting.card_chest
import kotlinx.android.synthetic.main.fragment_stretchting_part.*

class StretchtingPartFragment : Fragment(){

    private lateinit var viewModel: StrechtingPartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_stretchting_part, container, false)
        viewModel = ViewModelProviders.of(this).get(StrechtingPartViewModel::class.java)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val act : MainActivity = activity as MainActivity
        act.setActionBarTitle(getString(R.string.front_leg))

        card_chest.setOnClickListener {
            viewModel.navigate(view)
        }
    }
}