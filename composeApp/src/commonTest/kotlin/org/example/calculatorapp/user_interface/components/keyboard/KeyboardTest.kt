package org.example.calculatorapp.user_interface.components.keyboard

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT
import org.example.calculatorapp.user_interface.components.button.Button
import org.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import org.example.calculatorapp.user_interface.theme.Theme
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class KeyboardTest {
    @Test
    fun testIfComponentIsRendered() = runComposeUiTest {
        setContent {
            Keyboard(
                screenHeight = SMALL_SCREEN_HEIGHT
            ) {
                Button(
                    character = CalculatorCharacters.ONE,
                    characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                    backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                    borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    screenHeight = SMALL_SCREEN_HEIGHT
                ) {}
            }
        }

        onNodeWithText(CalculatorCharacters.ONE.value).assertExists()
    }
}