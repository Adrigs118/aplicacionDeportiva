package com.prueba.aplicaciondeportiva.viewModel.training

import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.ExerciseEntity
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.ExerciseRepository
import com.prueba.aplicaciondeportiva.database.Repository.StrechtingRepository
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.fragment_stretchting_description.*
import kotlinx.coroutines.launch
import java.lang.Exception

class ExerciseDialogViewModel : ViewModel() {

    val repository = ExerciseRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.exerciseDao())
    var entity : ExerciseEntity? = Utils.exerciseContext

    fun initVideo(webView_video : WebView){
        try{
            viewModelScope.launch {
                val url = ""
                webView_video.settings.javaScriptEnabled = true
                webView_video.settings.pluginState = WebSettings.PluginState.ON

                webView_video.loadUrl("https://www.youtube.com/embed/$url.?autoplay=1&vq=small")
                webView_video.webChromeClient = WebChromeClient()
            }
        }
        catch (e : Exception){
        }
    }

    fun initTexts(description : TextView, name : TextView){
        description.text = entity!!.description
        name.text = entity!!.name
    }

}