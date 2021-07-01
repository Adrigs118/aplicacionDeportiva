package com.prueba.aplicaciondeportiva.ui.weight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.Weight.WeightViewModel
import kotlinx.android.synthetic.main.fragment_weight.*


class WeightFragment : Fragment(){

    //region variables
    private lateinit var viewModel: WeightViewModel
    //endregion

    //region eventos
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_weight, container, false)
        viewModel = ViewModelProviders.of(this).get(WeightViewModel::class.java)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_imc.setOnClickListener {
            if(viewModel.checkFields(childFragmentManager, getString(R.string.warning_body_fields_no_exist),
                getString(R.string.warning_body_fields_no_valid))){
                viewModel.addImc(graph, editText_weight.text.toString(), editText_height.text.toString())
            }
        }

        imageView_man.setOnClickListener{
            viewModel.setGender(textView_gender, imageView_man)
        }

        viewModel.initFields(textView_gender, imageView_man)

        //region imcGraph
        viewModel.initGraph(graph)
        //endregion
    }

    //endregion
}