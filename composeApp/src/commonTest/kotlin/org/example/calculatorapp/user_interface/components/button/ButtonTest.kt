package org.example.calculatorapp.user_interface.components.button

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT
import org.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import org.example.calculatorapp.user_interface.theme.Theme
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class ButtonTest {
    private var state = false

    @Test
    fun testIfComponentIsRenderedAndDispatchesItsEvent() = runComposeUiTest {
        setContent {
            Button(
                CalculatorCharacters.ONE,
                Theme.colors.primaryBlueButtonCharacterColor,
                Theme.colors.primaryBlueButtonBackgroundColor,
                Theme.colors.primaryBlueButtonBorderColor,
                SMALL_SCREEN_HEIGHT
            ) {
                state = !state
            }

        }

        onNodeWithText(CalculatorCharacters.ONE.value).performClick()

        assertTrue(state)
    }
}
