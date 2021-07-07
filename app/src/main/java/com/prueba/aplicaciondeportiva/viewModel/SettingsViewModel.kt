package com.prueba.aplicaciondeportiva.viewModel

import android.app.Application
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.prueba.aplicaciondeportiva.database.Entity.ConfigEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.ConfigRepository
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.coroutines.launch


class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ConfigRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.configDao())

    fun update(language: String) {
        viewModelScope.launch {
            val update = repository.get()
            update.language = language
            repository.update(update)
        }
    }

    fun update_noti(notification :Boolean) {
        viewModelScope.launch {
            val update = repository.get()
            update.notifications = notification
            repository.update(update)
        }
    }

    fun updateLanguage(fragment : Fragment){
        val context = Utils.getApplicationContext()
        Utils.setAppLocale(context, Utils.language)
        updateMainActivity(fragment)
        update(Utils.language)
    }


    fun updateMainActivity(fragmentSetting: Fragment){
        viewModelScope.launch {
          val intent = fragmentSetting.activity!!.intent
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            fragmentSetting.activity!!.overridePendingTransition(0,0)
            fragmentSetting.activity!!.finish()

            fragmentSetting.activity!!.overridePendingTransition(0,0)
            fragmentSetting.startActivity(intent)
        }
    }

}