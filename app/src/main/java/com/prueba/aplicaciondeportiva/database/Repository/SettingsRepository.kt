package com.prueba.aplicaciondeportiva.database.Repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prueba.aplicaciondeportiva.database.Dao.SettingsDao
import com.prueba.aplicaciondeportiva.database.Entity.SettingsEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase

class SettingsRepository (application: Application){
    private val settingDao: SettingsDao? =
        GymDatabase.getInstance(application)?.settingsDao()

    fun insert(setting: SettingsEntity) {
        if(settingDao != null) InsertAsyncTask(settingDao).execute(setting)
    }

    fun getSettings(): LiveData<List<SettingsEntity>> {
        return settingDao?.getSettings() ?:MutableLiveData<List<SettingsEntity>>()
    }

    fun update(setting: SettingsEntity) {
        if(settingDao != null) UpdateAsyncTask(settingDao).execute(setting)
    }

    @Suppress("DEPRECATION")
    private class InsertAsyncTask(private val settingDao: SettingsDao) :
        AsyncTask<SettingsEntity, Void, Void>() {
        override  fun doInBackground(vararg  settings: SettingsEntity?) :Void? {
            for(setting in settings) {
                if(setting != null) settingDao.insert(setting)
            }
            return null
        }
    }

    @Suppress("DEPRECATION")
    private class UpdateAsyncTask(private val settingDao: SettingsDao) :
        AsyncTask<SettingsEntity, Void, Void>() {
        override  fun doInBackground(vararg  settings: SettingsEntity?) :Void? {
            for(setting in settings) {
                if(setting != null) settingDao.update(setting)
            }
            return null
        }
    }


}