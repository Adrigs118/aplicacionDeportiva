package com.prueba.aplicaciondeportiva.ui.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prueba.aplicaciondeportiva.database.Entity.SettingsEntity
import com.prueba.aplicaciondeportiva.database.Repository.SettingsRepository

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SettingsRepository(application)
    val setting : LiveData<List<SettingsEntity>> = repository.getSettings()

    fun saveSetting(setting: SettingsEntity) {
        repository.insert(setting)
    }

    fun updateSetting(setting: SettingsEntity) {
        repository.update(setting)
    }

}