package org.example.calculatorapp.user_interface.view_models

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import org.example.calculatorapp.user_interface.data_stores.ThemeDataStore
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalSettingsApi::class)
class ThemeModeViewModelTest {
    lateinit var themeModeViewModel: ThemeModeViewModel
    lateinit var themeDataStore: ThemeDataStore

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun beforeEach() {
        val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
        val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)

        themeDataStore = ThemeDataStore(keyValueDatabase)

        themeModeViewModel = ThemeModeViewModel(false, themeDataStore) {
            runBlocking { it() }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodToggleThemeTogglesThemeModeAndStoredOnKeyValueDatabase() = runTest {
        themeModeViewModel.toggleTheme()

        advanceUntilIdle()

        assertTrue(themeModeViewModel.themeMode.value)

        val storedThemeMode = themeDataStore.getNightModeThemeState()

        assertTrue(storedThemeMode)
    }
}