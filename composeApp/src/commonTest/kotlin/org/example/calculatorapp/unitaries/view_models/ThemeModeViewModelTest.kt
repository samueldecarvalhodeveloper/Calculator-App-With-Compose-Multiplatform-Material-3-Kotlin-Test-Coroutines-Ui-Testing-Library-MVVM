package org.example.calculatorapp.unitaries.view_models

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import org.example.calculatorapp.view_models.ThemeModeViewModel
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalSettingsApi::class)
class ThemeModeViewModelTest {
    lateinit var themeModeViewModel: ThemeModeViewModel
    lateinit var userInterfaceThemeStore: UserInterfaceThemeStore
    val standardTestDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun beforeEach() {
        val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
        val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)

        userInterfaceThemeStore = UserInterfaceThemeStore(keyValueDatabase)

        themeModeViewModel = ThemeModeViewModel(false, userInterfaceThemeStore)

        Dispatchers.setMain(standardTestDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodToggleThemeTogglesThemeModeAndStoredOnKeyValueDatabase() = runTest {
        themeModeViewModel.toggleTheme()

        advanceUntilIdle()

        assertTrue(themeModeViewModel.themeMode.value)

        val storedThemeMode = userInterfaceThemeStore.getNightModeThemeState()

        assertTrue(storedThemeMode)
    }
}