package com.prueba.aplicaciondeportiva.viewModel.Strechting

import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.StrechtingEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.StrechtingRepository
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.fragment_stretchting_description.*
import kotlinx.coroutines.launch
import java.lang.Exception

class StrechtingDialogViewModel : ViewModel() {

    val repository = StrechtingRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.strechtingDao())
    var entity : StrechtingEntity? = Utils.strechtingContext

    fun initVideo(webView_video : WebView){
        try{
            viewModelScope.launch {
                val url = entity!!.url
                webView_video.settings.javaScriptEnabled = true
                webView_video.settings.pluginState = WebSettings.PluginState.ON

                webView_video.loadUrl("https://www.youtube.com/embed/$url.?autoplay=1&vq=small")
                webView_video.webChromeClient = WebChromeClient()
            }
        }
        catch (e : Exception){
        }
    }

    fun initTexts(series : EditText, rep : EditText, weight : EditText, description : TextView, name : TextView){
        if (entity!!.series != 0) series.setText(entity!!.series)
        if (entity!!.rep != 0) rep.setText(entity!!.rep)
        if (entity!!.weight != 0.0F) weight.setText(entity!!.weight.toString())
        description.text = entity!!.description
        name.text = entity!!.tag
    }


    fun update(entity : StrechtingEntity) :Boolean{
        try{
            viewModelScope.launch {
                repository.update(entity)
            }
            return true
        }
        catch (e :Exception){
            return false
        }
    }
}