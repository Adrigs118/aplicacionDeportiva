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
import com.prueba.aplicaciondeportiva.viewModel.training.ExerciseDialogViewModel
import kotlinx.android.synthetic.main.fragment_exercise_description.*
import kotlinx.android.synthetic.main.fragment_stretchting_description.textView_title_description
import kotlinx.android.synthetic.main.fragment_stretchting_description.webView_video

class ExerciseDialogFragment : Fragment(){

    private lateinit var viewModel: ExerciseDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_exercise_description, container, false)
        viewModel = ViewModelProviders.of(this).get(ExerciseDialogViewModel::class.java)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val act : MainActivity = activity as MainActivity
        act.setActionBarTitle("Ejercicio abdomen")
        viewModel.initVideo(webView_video)
        viewModel.initTexts(textView_description_exercise, textView_title_description_exercise )
    }
}