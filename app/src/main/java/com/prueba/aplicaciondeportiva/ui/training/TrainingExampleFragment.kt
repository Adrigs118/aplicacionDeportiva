package com.prueba.aplicaciondeportiva.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_stretchting_description.*
import android.webkit.WebChromeClient
import android.webkit.WebSettings.PluginState
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.utils.Utils
import com.prueba.aplicaciondeportiva.viewModel.Strechting.StrechtingDialogViewModel
import com.prueba.aplicaciondeportiva.viewModel.training.TrainingExampleViewModel
import kotlinx.android.synthetic.main.fragment_training_example.*

class TrainingExampleFragment : Fragment(){

    private lateinit var viewModel: TrainingExampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_training_example, container, false)
        viewModel = ViewModelProviders.of(this).get(TrainingExampleViewModel::class.java)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val act : MainActivity = activity as MainActivity
        act.setActionBarTitle("Principiantes")
        viewModel.initTexts(textView_rutina_days, textView_rutina_difficult, textView_rutina_tag,
            textView_rutina_title, textView_rutina_descripcion)
        viewModel.addDays(training_linearLayout, this.context!!, view)
    }

}