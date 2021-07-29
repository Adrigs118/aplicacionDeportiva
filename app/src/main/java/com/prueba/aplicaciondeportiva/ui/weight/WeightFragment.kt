package com.prueba.aplicaciondeportiva.ui.weight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.viewModel.Weight.WeightViewModel
import kotlinx.android.synthetic.main.fragment_weight.*
import android.view.View.OnFocusChangeListener

import com.prueba.aplicaciondeportiva.database.Entity.BodyEntity


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
                getString(R.string.warning_body_fields_no_valid), editText_height, editText_weight)){
                viewModel.addImc(graph, editText_height.text.toString(), editText_weight.text.toString())
            }
        }

        imageView_man.setOnClickListener{
            viewModel.setGender(textView_gender, imageView_man)
        }

        editText_weight.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (!editText_weight.text.isNullOrEmpty()){
                    viewModel.body[0].weight = editText_weight.text.toString().toFloat()
                    viewModel.update(viewModel.body[0])
                }
            }
        })

        editText_height.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (!editText_weight.text.isNullOrEmpty()){
                    viewModel.body[0].height = editText_height.text.toString().toInt()
                    viewModel.update(viewModel.body[0])
                }
            }
        })

        editText_age.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (!editText_weight.text.isNullOrEmpty()){
                    viewModel.body[0].age = editText_age.text.toString().toInt()
                    viewModel.update(viewModel.body[0])
                }
            }
        })

        viewModel.initFields(textView_gender, imageView_man, editText_weight, editText_height, editText_age,
            graph)

        //region imcGraph
        viewModel.initGraph(graph)
        //endregion
    }

    //endregion
}