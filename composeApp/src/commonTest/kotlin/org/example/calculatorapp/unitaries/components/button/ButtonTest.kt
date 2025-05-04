package org.example.calculatorapp.unitaries.components.button

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.example.calculatorapp.components.button.Button
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT
import org.example.calculatorapp.theme.Theme
import org.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class ButtonTest {
    private var state = false

    @Test
    fun testIfComponentIsRenderedAndDispatchesItsEvent() = runComposeUiTest {
        setContent {
            Button(
                UserInterfaceCalculatorCharacters.ONE,
                Theme.colors.primaryBlueButtonCharacterColor,
                Theme.colors.primaryBlueButtonBackgroundColor,
                Theme.colors.primaryBlueButtonBorderColor,
                SMALL_SCREEN_HEIGHT
            ) {
                state = !state
            }

        }

        onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()

        assertTrue(state)
    }
}
