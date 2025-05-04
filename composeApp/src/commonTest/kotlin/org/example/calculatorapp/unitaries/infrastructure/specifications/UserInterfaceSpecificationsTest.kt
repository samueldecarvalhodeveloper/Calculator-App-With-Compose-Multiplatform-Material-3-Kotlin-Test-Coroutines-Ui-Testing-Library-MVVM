package org.example.calculatorapp.unitaries.infrastructure.specifications

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.UserInterfaceConstants.LARGER_SCREEN_WIDTH
import org.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALLER_SCREEN_WIDTH
import org.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
import org.example.calculatorapp.infrastructure.UserInterfaceSpecifications.isOnKeyValueDatabase
import org.example.calculatorapp.infrastructure.UserInterfaceSpecifications.isScreenHeightSmall
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(ExperimentalSettingsApi::class)
class UserInterfaceSpecificationsTest {
    private lateinit var keyValueDatabaseImplementation: SuspendSettings

    @BeforeTest
    fun beforeEach() {
        keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
    }

    @Test
    fun testIfMethodIsScreenHeightSmallReturnsTrueWhenDeviceScreenIsSmaller() {
        val userInterfaceIsSmall = isScreenHeightSmall(SMALLER_SCREEN_WIDTH)
        val userInterfaceIsLarge = isScreenHeightSmall(LARGER_SCREEN_WIDTH)

        assertTrue(userInterfaceIsSmall)
        assertFalse(userInterfaceIsLarge)
    }

    @Test
    fun testIfMethodIsOnKeyValueDatabaseReturnsTrueWhenKeyIsOnKeyValueDatabase() {
        runBlocking {
            keyValueDatabaseImplementation.putString(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                SIMPLE_CALCULATION_EXPRESSION
            )

            val keyIsOnKeyValueDatabase = isOnKeyValueDatabase(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                keyValueDatabaseImplementation
            )
            val keyNotIsOnKeyValueDatabase =
                isOnKeyValueDatabase(THEME_KEY, keyValueDatabaseImplementation)

            assertTrue(keyIsOnKeyValueDatabase)
            assertFalse(keyNotIsOnKeyValueDatabase)
        }
    }
}
