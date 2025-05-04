package org.example.calculatorapp.integrations

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.russhwolf.settings.ExperimentalSettingsApi
import org.example.calculatorapp.application.Application
import org.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import kotlin.test.Test

@OptIn(ExperimentalSettingsApi::class)
class UserInterfaceExecutingCalculationTest {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfCalculationExpressionIsExecutedOnUserInterface() = runComposeUiTest {
        setContent {
            Application()
        }

        onNodeWithText(UserInterfaceCalculatorCharacters.CLEAN.value).performClick()

        onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()
        onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value).performClick()
        onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()
        onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()

        onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value).performClick()

        onNodeWithText(
            UserInterfaceCalculatorCharacters.ONE.value + UserInterfaceCalculatorCharacters.TWO.value
        ).assertExists()
    }
}