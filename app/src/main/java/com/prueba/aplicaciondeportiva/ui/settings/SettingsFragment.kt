package com.prueba.aplicaciondeportiva.ui.settings

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.utils.Utils
import com.prueba.aplicaciondeportiva.viewModel.SettingsViewModel
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment(){

    private lateinit var settingsViewModel: SettingsViewModel
    private var init = false

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

        if(Utils.language == "es"){
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
                    Utils.language = "es"
                }
                else{
                    Utils.language = "en"
                }
                if(init) settingsViewModel.updateLanguage(get())
                else init = true
            }
        }
    }

    fun get() :Fragment {return this}

    fun reload(){
            /*val ft: FragmentTransaction = this.fragmentManager!!.beginTransaction()
            ft.detach(this)
            ft.attach(this)
            ft.commit()*/
    }

}