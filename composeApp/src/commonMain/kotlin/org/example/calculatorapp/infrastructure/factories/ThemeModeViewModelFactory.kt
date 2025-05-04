package org.example.calculatorapp.infrastructure.factories

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import org.example.calculatorapp.view_models.ThemeModeViewModel

@OptIn(ExperimentalSettingsApi::class)
object ThemeModeViewModelFactory {
    private lateinit var instance: ThemeModeViewModel

    fun getInstance(keyValueDatabaseImplementation: SuspendSettings): ThemeModeViewModel {
        if (this::instance.isInitialized.not()) {
            runBlocking {
                val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)
                val userInterfaceThemeStore = UserInterfaceThemeStore(keyValueDatabase)
                val storedThemeMode = userInterfaceThemeStore.getNightModeThemeState()

                instance = ThemeModeViewModel(storedThemeMode, userInterfaceThemeStore)
            }
        }

        return instance
    }
}