package org.example.calculatorapp.user_interface_theme_store

import org.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class UserInterfaceThemeStore(private val keyValueDatabase: KeyValueDatabase) {
    suspend fun getNightModeThemeState(): Boolean {
        return try {
            keyValueDatabase.getBooleanValue(THEME_KEY)
        } catch (_: NotExistingKeyException) {
            false
        }
    }

    suspend fun setNightModeThemeState(state: Boolean) {
        keyValueDatabase.setBooleanValue(THEME_KEY, state)
    }
}