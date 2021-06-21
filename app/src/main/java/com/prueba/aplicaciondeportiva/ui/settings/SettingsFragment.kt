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
import com.prueba.aplicaciondeportiva.Utils
import com.prueba.aplicaciondeportiva.ui.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_settings.*
import org.intellij.lang.annotations.Language


class SettingsFragment : Fragment(){

    private var init = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_settings, container, false)
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

        if(context!!.resources.configuration.locale.toString().contains("es")){
            languages.setSelection(1)
        }
        else
            languages.setSelection(0)

        languages.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position == 1)
                    Utils.setAppLocale(Utils.getApplicationContext(), "es")
                else
                    Utils.setAppLocale(Utils.getApplicationContext(), "en")

                if(init) {
                    init = false
                    reload()}
                else init = true
            }
        }
    }

    fun reload(){
            /*val ft: FragmentTransaction = this.fragmentManager!!.beginTransaction()
            ft.detach(this)
            ft.attach(this)
            ft.commit()*/
    }

}