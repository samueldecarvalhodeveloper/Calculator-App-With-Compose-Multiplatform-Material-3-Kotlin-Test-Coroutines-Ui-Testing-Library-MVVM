package org.example.calculatorapp.infrastructure.anticorruption_layer

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import org.example.calculatorapp.infrastructure.UserInterfaceSpecifications.isOnKeyValueDatabase
import org.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

@OptIn(ExperimentalSettingsApi::class)
class KeyValueDatabase(private val keyValueDatabaseImplementation: SuspendSettings) {
    suspend fun getStringValue(key: String): String {
        if (isOnKeyValueDatabase(key, keyValueDatabaseImplementation)) {
            return keyValueDatabaseImplementation.getString(key, "")
        } else {
            throw NotExistingKeyException(key)
        }
    }

    suspend fun getBooleanValue(key: String): Boolean {
        if (isOnKeyValueDatabase(key, keyValueDatabaseImplementation)) {
            return keyValueDatabaseImplementation.getBoolean(key, false)
        } else {
            throw NotExistingKeyException(key)
        }
    }

    suspend fun setBooleanValue(key: String, value: Boolean) {
        keyValueDatabaseImplementation.putBoolean(key, value)
    }

    suspend fun setStringValue(key: String, value: String) {
        keyValueDatabaseImplementation.putString(key, value)
    }
}