package org.example.calculatorapp.user_interface.application

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class ApplicationTest {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfComponentIsRenderedAndDispatchesItsEvent() = runComposeUiTest {
        setContent {
            Application()
        }

        onNodeWithText(CalculatorCharacters.CLEAN.value).performClick()

        onNodeWithText(CalculatorCharacters.ONE.value).performClick()
        onNodeWithText(CalculatorCharacters.ADDITION.value).performClick()
        onNodeWithText(CalculatorCharacters.ONE.value).performClick()
        onNodeWithText(CalculatorCharacters.ONE.value).performClick()

        onNodeWithText(CalculatorCharacters.EVALUATION.value).performClick()

        onNodeWithText(
            CalculatorCharacters.ONE.value + CalculatorCharacters.TWO.value
        ).assertExists()
    }
}