package com.prueba.aplicaciondeportiva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.content.Context
import androidx.core.content.ContextCompat.startActivities
import androidx.core.content.ContextCompat.startActivity
import java.util.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService



class Utils() : AppCompatActivity(){

    companion object  {

        private lateinit  var context: Context

        fun initUtils(context: Context){
            setApplicationContext(context)
        }

        fun getApplicationContext() : Context{
            return this.context
        }

        fun setApplicationContext(context: Context){
            this.context = context
        }

        @Suppress("DEPRECATION")
        fun setAppLocale(context: Context, language: String) {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val config = context.resources.configuration
            config.setLocale(locale)
            context.createConfigurationContext(config)
            context.resources.updateConfiguration(config,context.resources.displayMetrics)
        }





    }

}
