package com.prueba.aplicaciondeportiva.ui.settings

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.content.res.Configuration
import android.os.Bundle
import com.prueba.aplicaciondeportiva.R
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.Utils
import com.prueba.aplicaciondeportiva.database.Entity.SettingsEntity
import com.prueba.aplicaciondeportiva.ui.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_settings.*
import org.intellij.lang.annotations.Language


class SettingsFragment : Fragment(){

    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var language: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_settings, container, false)
        settingsViewModel = run {
            ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        }

        return root
    }

    @Suppress("DEPRECATION")
    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ArrayAdapter.createFromResource(
            this.context!!,
            com.prueba.aplicaciondeportiva.R.array.languages_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            languages.adapter = adapter
        }

        initialize()

        if(language == "es"){
            languages.setSelection(1)
        }
        else{
            languages.setSelection(0)
        }

        languages.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position == 1){
                    language = "es"
                }
                else{
                    language = "en"
                }

                Utils.setAppLocale(Utils.getApplicationContext(), language)
                updateSettings()
            }
        }
    }
/*
    private fun addObserver(){
        val observer = Observer<List<SettingsEntity>> { settings ->
            if( settings != null){
                for (setting in settings){

                }
            }
        }
        settingsViewModel.setting.observe(this, observer)
    }
    */


    private fun initialize(){
       /* val settings : MutableLiveData<List<SettingsEntity>> = settingsViewModel.setting
        for(setting :SettingsEntity in settings.value){

        }
        */

    }

    private fun updateSettings() {
        settingsViewModel.updateSetting(SettingsEntity(this))
    }

    fun reload(){
            /*val ft: FragmentTransaction = this.fragmentManager!!.beginTransaction()
            ft.detach(this)
            ft.attach(this)
            ft.commit()*/
    }



    // region Getters&Setters

    public fun getLanguage() :String{
        return language
    }

    public fun setLanguage(language: String){
        this.language = language
    }

    // endregion

}