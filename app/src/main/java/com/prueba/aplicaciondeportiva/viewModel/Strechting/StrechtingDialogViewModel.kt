package com.prueba.aplicaciondeportiva.viewModel.Strechting

import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

                webView_video.settings.javaScriptEnabled = true
                webView_video.settings.pluginState = WebSettings.PluginState.ON

                webView_video.loadUrl("https://www.youtube.com/embed/$entity.url?autoplay=1&vq=small")
                webView_video.webChromeClient = WebChromeClient()
            }
        }
        catch (e : Exception){
        }
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