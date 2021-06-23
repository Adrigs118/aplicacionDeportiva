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

        private var dietContext: Diet? = null

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

        fun dietToString(diet : Diet) : Array<String>{
            val array = arrayOf(diet.getName(), diet.getDescription(),
                diet.getMonday().getBreakfast(), diet.getMonday().getLunch(), diet.getMonday().getMeal(),
                diet.getMonday().getSnack(), diet.getMonday().getDinner(),
                diet.getTuesday().getBreakfast(), diet.getTuesday().getLunch(), diet.getTuesday().getMeal(),
                diet.getTuesday().getSnack(), diet.getTuesday().getDinner(),
                diet.getWednesday().getBreakfast(), diet.getWednesday().getLunch(), diet.getWednesday().getMeal(),
                diet.getWednesday().getSnack(), diet.getWednesday().getDinner(),
                diet.getThursday().getBreakfast(), diet.getThursday().getLunch(), diet.getThursday().getMeal(),
                diet.getThursday().getSnack(), diet.getThursday().getDinner(),
                diet.getFriday().getBreakfast(), diet.getFriday().getLunch(), diet.getFriday().getMeal(),
                diet.getFriday().getSnack(), diet.getFriday().getDinner(),
                diet.getSaturday().getBreakfast(), diet.getSaturday().getLunch(), diet.getSaturday().getMeal(),
                diet.getSaturday().getSnack(), diet.getSaturday().getDinner(),
                diet.getSunday().getBreakfast(), diet.getSunday().getLunch(), diet.getSunday().getMeal(),
                diet.getSunday().getSnack(), diet.getSunday().getDinner()
                )
            return array
        }

        fun stringToDiet(array: Array<String>) : Diet {
            val diet = Diet(array[0], array[1],
                Diet.DayDiet(array[2], array[3], array[4], array[5], array[6]),
                Diet.DayDiet(array[7], array[8], array[9], array[10], array[11]),
                Diet.DayDiet(array[12], array[13], array[14], array[15], array[16]),
                Diet.DayDiet(array[17], array[18], array[19], array[20], array[21]),
                Diet.DayDiet(array[22], array[23], array[24], array[25], array[26]),
                Diet.DayDiet(array[27], array[28], array[29], array[30], array[31]),
                Diet.DayDiet(array[32], array[33], array[34], array[35], array[36]))
            return diet
        }

        public fun setDietContext(diet: Diet) {this.dietContext = diet}

        public fun getDietContext() : Diet? {return dietContext}

    }

}
