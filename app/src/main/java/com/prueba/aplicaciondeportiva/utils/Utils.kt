package com.prueba.aplicaciondeportiva.utils

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import java.util.*


class Utils() : AppCompatActivity(){

    companion object  {

        private var dietContext: DietWithDay? = null

        private lateinit  var context: Context

        fun initUtils(context: Context){
            setApplicationContext(context)
        }

        fun getApplicationContext() : Context{
            return context
        }

        fun setApplicationContext(context: Context){
            Companion.context = context
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

        public fun setDietContext(diet: DietWithDay?) {
            dietContext = diet}

        public fun getDietContext() : DietWithDay? {return dietContext
        }

    }

}
