package org.example.calculatorapp.unitaries.infrastructure.factories

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
import org.example.calculatorapp.infrastructure.factories.ThemeModeViewModelFactory
import kotlin.test.Test
import kotlin.test.assertNotNull

@OptIn(ExperimentalSettingsApi::class)
class ThemeModeViewModelFactoryTest {
    @Test
    fun testIfMethodGetInstanceReturnsAnWorkingInstance() {
        runBlocking {
            val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

            keyValueDatabaseImplementation.putBoolean(THEME_KEY, true)

            val instance = ThemeModeViewModelFactory.getInstance(keyValueDatabaseImplementation)

            assertNotNull(instance)
        }
    }
}