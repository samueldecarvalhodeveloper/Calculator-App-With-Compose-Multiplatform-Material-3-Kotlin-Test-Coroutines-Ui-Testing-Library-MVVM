package org.example.calculatorapp.infrastructure.adapters

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.domains.CalculatorConstants.EXPRESSION_TO_BE_EVALUATED
import org.example.calculatorapp.constants.UserInterfaceConstants.EXPRESSION_KEY
import org.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
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
                EXPRESSION_KEY,
                EXPRESSION_TO_BE_EVALUATED
            )

            val storedStringValue = keyValueDatabase.getStringValue(
                EXPRESSION_KEY
            )

            assertEquals(EXPRESSION_TO_BE_EVALUATED, storedStringValue)
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
                EXPRESSION_KEY,
                EXPRESSION_TO_BE_EVALUATED
            )

            val storedStringValue = keyValueDatabaseImplementation.getString(
                EXPRESSION_KEY,
                ""
            )

            assertEquals(EXPRESSION_TO_BE_EVALUATED, storedStringValue)
        }
    }
}