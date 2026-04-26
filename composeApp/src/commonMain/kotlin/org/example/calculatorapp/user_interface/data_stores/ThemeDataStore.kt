package org.example.calculatorapp.user_interface.data_stores

import org.example.calculatorapp.constants.UserInterfaceConstants
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import org.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class ThemeDataStore(private val keyValueDatabase: KeyValueDatabase) {
    suspend fun getNightModeThemeState(): Boolean {
        return try {
            keyValueDatabase.getBooleanValue(UserInterfaceConstants.THEME_KEY)
        } catch (_: NotExistingKeyException) {
            false
        }
    }

    suspend fun setNightModeThemeState(state: Boolean) {
        keyValueDatabase.setBooleanValue(UserInterfaceConstants.THEME_KEY, state)
    }
}