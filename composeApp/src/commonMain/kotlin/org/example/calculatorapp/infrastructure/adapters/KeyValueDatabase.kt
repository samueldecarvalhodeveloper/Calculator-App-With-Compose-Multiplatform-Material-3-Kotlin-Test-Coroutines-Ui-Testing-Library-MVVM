package org.example.calculatorapp.infrastructure.adapters

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.example.calculatorapp.user_interface.internals.checkers.UserInterfaceChecker.isOnKeyValueDatabase
import org.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

@OptIn(ExperimentalSettingsApi::class)
class KeyValueDatabase(private val keyValueDatabaseImplementation: SuspendSettings) {
    suspend fun getStringValue(key: String): String {
        if (isOnKeyValueDatabase(key, keyValueDatabaseImplementation)) {
            return withContext(Dispatchers.IO) { keyValueDatabaseImplementation.getString(key, "") }
        } else {
            throw NotExistingKeyException(key)
        }
    }

    suspend fun getBooleanValue(key: String): Boolean {
        if (isOnKeyValueDatabase(key, keyValueDatabaseImplementation)) {
            return withContext(Dispatchers.IO) { keyValueDatabaseImplementation.getBoolean(key, false) }
        } else {
            throw NotExistingKeyException(key)
        }
    }

    suspend fun setBooleanValue(key: String, value: Boolean) {
        withContext(Dispatchers.IO) { keyValueDatabaseImplementation.putBoolean(key, value) }
    }

    suspend fun setStringValue(key: String, value: String) {
        withContext(Dispatchers.IO) { keyValueDatabaseImplementation.putString(key, value) }
    }
}