package com.prueba.aplicaciondeportiva.ui.stretchting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_stretchting_description.*
import android.webkit.WebChromeClient
import android.webkit.WebSettings.PluginState

class StretchtingDialogFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_stretchting_description, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoID = "W0M0yfN8Tkc"

        webView_video.settings.javaScriptEnabled = true
        webView_video.settings.pluginState = PluginState.ON

        webView_video.loadUrl("https://www.youtube.com/embed/$videoID?autoplay=1&vq=small")
        webView_video.webChromeClient = WebChromeClient()
    }
}