package org.example.calculatorapp.unitaries.user_interface_theme_store

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalSettingsApi::class)
class UserInterfaceThemeStoreTest {
    private lateinit var keyValueDatabase: KeyValueDatabase
    private lateinit var userInterfaceThemeStore: UserInterfaceThemeStore

    @BeforeTest
    fun beforeEach() {
        var keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

        keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)

        userInterfaceThemeStore = UserInterfaceThemeStore(keyValueDatabase)
    }

    @Test
    fun testIfMethodGetNightModeThemeStateReturnsStoredThemeFromKeyValueDatabase() {
        runBlocking {
            keyValueDatabase.setBooleanValue(THEME_KEY, true)

            val storedTheme = userInterfaceThemeStore.getNightModeThemeState()

            assertTrue(storedTheme)
        }
    }

    @Test
    fun testIfMethodSetNightModeThemeStateUpdatesStoredThemeOnKeyValueDatabase() {
        runBlocking {
            userInterfaceThemeStore.setNightModeThemeState(true)

            val storedTheme = keyValueDatabase.getBooleanValue(THEME_KEY)

            assertTrue(storedTheme)
        }
    }
}