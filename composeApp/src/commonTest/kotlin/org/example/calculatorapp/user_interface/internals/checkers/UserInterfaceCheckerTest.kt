package org.example.calculatorapp.user_interface.internals.checkers

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.domains.CalculatorConstants.EXPRESSION_TO_BE_EVALUATED
import org.example.calculatorapp.constants.UserInterfaceConstants.LARGER_SCREEN_WIDTH
import org.example.calculatorapp.constants.UserInterfaceConstants.EXPRESSION_KEY
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALLER_SCREEN_WIDTH
import org.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
import org.example.calculatorapp.user_interface.internals.checkers.UserInterfaceChecker.isOnKeyValueDatabase
import org.example.calculatorapp.user_interface.internals.checkers.UserInterfaceChecker.isScreenHeightSmall
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(ExperimentalSettingsApi::class)
class UserInterfaceCheckerTest {
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
                EXPRESSION_KEY,
                EXPRESSION_TO_BE_EVALUATED
            )

            val keyIsOnKeyValueDatabase = isOnKeyValueDatabase(
                EXPRESSION_KEY,
                keyValueDatabaseImplementation
            )
            val keyNotIsOnKeyValueDatabase =
                isOnKeyValueDatabase(THEME_KEY, keyValueDatabaseImplementation)

            assertTrue(keyIsOnKeyValueDatabase)
            assertFalse(keyNotIsOnKeyValueDatabase)
        }
    }
}
