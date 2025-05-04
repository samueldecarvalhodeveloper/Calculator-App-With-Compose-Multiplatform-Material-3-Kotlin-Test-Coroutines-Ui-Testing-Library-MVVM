package org.example.calculatorapp.unitaries.theme

import org.example.calculatorapp.theme.ColorScheme
import org.example.calculatorapp.theme.NEUTRALS_100
import org.example.calculatorapp.theme.NEUTRALS_900
import org.example.calculatorapp.theme.PRIMARY_100
import org.example.calculatorapp.theme.PRIMARY_200
import org.example.calculatorapp.theme.PRIMARY_300
import org.example.calculatorapp.theme.PRIMARY_400
import org.example.calculatorapp.theme.PRIMARY_500
import org.example.calculatorapp.theme.PRIMARY_600
import org.example.calculatorapp.theme.PRIMARY_700
import org.example.calculatorapp.theme.PRIMARY_900
import org.example.calculatorapp.theme.SECONDARY_400
import org.example.calculatorapp.theme.SECONDARY_500
import org.example.calculatorapp.theme.SECONDARY_700
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorSchemeTest {
    @Test
    fun testIfMethodCopyReturnsACopyOfClass() {
        val colorScheme = ColorScheme(
            appBackgroundColor = PRIMARY_200,
            primaryBlueButtonCharacterColor = PRIMARY_900,
            viewfinderBorderColor = PRIMARY_500,
            primaryBlueButtonBorderColor = PRIMARY_500,
            yellowButtonBorderColor = SECONDARY_700,
            yellowButtonCharacterColor = NEUTRALS_900,
            yellowButtonBackgroundColor = SECONDARY_500,
            primaryBlueButtonBackgroundColor = PRIMARY_400,
            viewfinderBackgroundColor = PRIMARY_100,
            viewfinderTextColor = NEUTRALS_900,
            secondaryBlueButtonBorderColor = NEUTRALS_900,
            secondaryBlueButtonCharacterColor = NEUTRALS_100,
            secondaryBlueButtonBackgroundColor = PRIMARY_900,
            rippleColor = NEUTRALS_900
        )

        val copyOfColorScheme = colorScheme.copy()

        assertEquals(
            colorScheme.primaryBlueButtonBackgroundColor.value,
            copyOfColorScheme.primaryBlueButtonBackgroundColor.value
        )
    }

    @Test
    fun updateColorSchemeChangesTheCurrentColorScheme() {
        val colorScheme = ColorScheme(
            appBackgroundColor = PRIMARY_200,
            primaryBlueButtonCharacterColor = PRIMARY_900,
            viewfinderBorderColor = PRIMARY_500,
            primaryBlueButtonBorderColor = PRIMARY_500,
            yellowButtonBorderColor = SECONDARY_700,
            yellowButtonCharacterColor = NEUTRALS_900,
            yellowButtonBackgroundColor = SECONDARY_500,
            primaryBlueButtonBackgroundColor = PRIMARY_400,
            viewfinderBackgroundColor = PRIMARY_100,
            viewfinderTextColor = NEUTRALS_900,
            secondaryBlueButtonBorderColor = NEUTRALS_900,
            secondaryBlueButtonCharacterColor = NEUTRALS_100,
            secondaryBlueButtonBackgroundColor = PRIMARY_900,
            rippleColor = NEUTRALS_900
        )

        assertEquals(PRIMARY_200.value, colorScheme.appBackgroundColor.value)

        val newColorScheme = ColorScheme(
            appBackgroundColor = PRIMARY_900,
            primaryBlueButtonCharacterColor = PRIMARY_100,
            viewfinderBorderColor = PRIMARY_600,
            primaryBlueButtonBorderColor = PRIMARY_600,
            yellowButtonBorderColor = SECONDARY_400,
            yellowButtonCharacterColor = NEUTRALS_900,
            yellowButtonBackgroundColor = SECONDARY_500,
            primaryBlueButtonBackgroundColor = PRIMARY_700,
            viewfinderBackgroundColor = PRIMARY_700,
            viewfinderTextColor = NEUTRALS_100,
            secondaryBlueButtonBorderColor = PRIMARY_300,
            secondaryBlueButtonCharacterColor = NEUTRALS_900,
            secondaryBlueButtonBackgroundColor = PRIMARY_400,
            rippleColor = NEUTRALS_100
        )

        colorScheme.updateColorScheme(newColorScheme)

        assertEquals(colorScheme.appBackgroundColor.value, newColorScheme.appBackgroundColor.value)
    }
}