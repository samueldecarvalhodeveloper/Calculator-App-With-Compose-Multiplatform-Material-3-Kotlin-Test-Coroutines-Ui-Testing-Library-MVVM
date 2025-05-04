package org.example.calculatorapp.unitaries.components.keyboard

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.example.calculatorapp.components.button.Button
import org.example.calculatorapp.components.keyboard.Keyboard
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT
import org.example.calculatorapp.theme.Theme
import org.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
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
                    character = UserInterfaceCalculatorCharacters.ONE,
                    characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                    backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                    borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    screenHeight = SMALL_SCREEN_HEIGHT
                ) {}
            }
        }

        onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).assertExists()
    }
}