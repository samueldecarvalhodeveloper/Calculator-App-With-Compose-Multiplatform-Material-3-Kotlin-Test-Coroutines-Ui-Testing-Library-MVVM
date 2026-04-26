package org.example.calculatorapp.dependency_injections

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import org.example.calculatorapp.user_interface.data_stores.ThemeDataStore
import org.example.calculatorapp.user_interface.view_models.ThemeModeViewModel

@OptIn(ExperimentalSettingsApi::class)
object ThemeModeViewModelFactory {
    private lateinit var instance: ThemeModeViewModel

    fun getInstance(keyValueDatabaseImplementation: SuspendSettings): ThemeModeViewModel {
        if (this::instance.isInitialized.not()) {
            runBlocking {
                val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)
                val themeDataStore = ThemeDataStore(keyValueDatabase)
                val storedThemeMode = themeDataStore.getNightModeThemeState()

                instance = ThemeModeViewModel(storedThemeMode, themeDataStore)
            }
        }

        return instance
    }
}