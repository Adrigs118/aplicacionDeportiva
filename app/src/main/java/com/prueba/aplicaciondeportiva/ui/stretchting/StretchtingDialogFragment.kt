package com.prueba.aplicaciondeportiva.ui.stretchting

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

class StretchtingDialogFragment : Fragment(){

    private lateinit var viewModel: StrechtingDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_stretchting_description, container, false)
        viewModel = ViewModelProviders.of(this).get(StrechtingDialogViewModel::class.java)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val act : MainActivity = activity as MainActivity
        act.setActionBarTitle(getString(R.string.front_leg))
        viewModel.initVideo(webView_video)
        viewModel.initTexts(editText_series, editText_rep, editText_weight_strechting, textView_description, textView_title_description)
    }

}