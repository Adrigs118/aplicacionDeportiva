package com.prueba.aplicaciondeportiva.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prueba.aplicaciondeportiva.ui.settings.SettingsFragment
import org.jetbrains.annotations.NotNull

@Entity(tableName = SettingsEntity.TABLE_NAME)
data class SettingsEntity (
    @ColumnInfo(name = "language") @NotNull var language: String) {

    companion object {
        const val TABLE_NAME = "settings"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "settings_id")
    var settingsId: Short? = null

    constructor(setting: SettingsFragment) : this(setting.getLanguage())
}