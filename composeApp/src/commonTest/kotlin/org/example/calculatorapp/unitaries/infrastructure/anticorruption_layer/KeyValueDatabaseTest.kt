package org.example.calculatorapp.unitaries.infrastructure.anticorruption_layer

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import org.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalSettingsApi::class)
class KeyValueDatabaseTest {
    private lateinit var keyValueDatabaseImplementation: SuspendSettings
    private lateinit var keyValueDatabase: KeyValueDatabase

    @BeforeTest
    fun beforeEach() {
        keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

        keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)
    }

    @Test
    fun testIfMethodGetStringValueReturnsStoredStringFromKeyValueDatabase() {
        runBlocking {
            keyValueDatabaseImplementation.putString(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                SIMPLE_CALCULATION_EXPRESSION
            )

            val storedStringValue = keyValueDatabase.getStringValue(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY
            )

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, storedStringValue)
        }
    }

    @Test
    fun testIfMethodGetBooleanValueReturnsStoredBooleanFromKeyValueDatabase() {
        runBlocking {
            keyValueDatabaseImplementation.putBoolean(
                THEME_KEY,
                true
            )

            val storedBooleanValue = keyValueDatabase.getBooleanValue(
                THEME_KEY
            )

            assertTrue(storedBooleanValue)
        }
    }

    @Test
    fun testIfMethodSetBooleanValueStoredBooleanOnKeyValueDatabase() {
        runBlocking {
            keyValueDatabase.setBooleanValue(
                THEME_KEY,
                true
            )

            val storedBooleanValue = keyValueDatabaseImplementation.getBoolean(
                THEME_KEY,
                false
            )

            assertTrue(storedBooleanValue)
        }
    }

    @Test
    fun testIfMethodSetStringValueStoredStringOnKeyValueDatabase() {
        runBlocking {
            keyValueDatabase.setStringValue(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                SIMPLE_CALCULATION_EXPRESSION
            )

            val storedStringValue = keyValueDatabaseImplementation.getString(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                ""
            )

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, storedStringValue)
        }
    }
}