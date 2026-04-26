package org.example.calculatorapp.user_interface.data_stores

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.UserInterfaceConstants
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalSettingsApi::class)
class ThemeDataStoreTest {
    private lateinit var keyValueDatabase: KeyValueDatabase
    private lateinit var themeDataStore: ThemeDataStore

    @BeforeTest
    fun beforeEach() {
        val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

        keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)

        themeDataStore = ThemeDataStore(keyValueDatabase)
    }

    @Test
    fun testIfMethodGetNightModeThemeStateReturnsStoredThemeFromKeyValueDatabase() {
        runBlocking {
            keyValueDatabase.setBooleanValue(UserInterfaceConstants.THEME_KEY, true)

            val storedTheme = themeDataStore.getNightModeThemeState()

            assertTrue(storedTheme)
        }
    }

    @Test
    fun testIfMethodSetNightModeThemeStateUpdatesStoredThemeOnKeyValueDatabase() {
        runBlocking {
            themeDataStore.setNightModeThemeState(true)

            val storedTheme = keyValueDatabase.getBooleanValue(UserInterfaceConstants.THEME_KEY)

            assertTrue(storedTheme)
        }
    }
}