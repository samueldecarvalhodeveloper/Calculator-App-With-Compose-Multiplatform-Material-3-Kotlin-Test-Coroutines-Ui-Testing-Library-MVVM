package org.example.calculatorapp.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class ColorScheme(
    appBackgroundColor: Color,
    viewfinderBackgroundColor: Color,
    viewfinderTextColor: Color,
    viewfinderBorderColor: Color,
    primaryBlueButtonBackgroundColor: Color,
    primaryBlueButtonCharacterColor: Color,
    primaryBlueButtonBorderColor: Color,
    secondaryBlueButtonBackgroundColor: Color,
    secondaryBlueButtonCharacterColor: Color,
    secondaryBlueButtonBorderColor: Color,
    yellowButtonBackgroundColor: Color,
    yellowButtonCharacterColor: Color,
    yellowButtonBorderColor: Color,
    rippleColor: Color
) {
    var appBackgroundColor: Color by mutableStateOf(appBackgroundColor)
        private set
    var viewfinderBackgroundColor: Color by mutableStateOf(viewfinderBackgroundColor)
        private set
    var viewfinderTextColor: Color by mutableStateOf(viewfinderTextColor)
        private set
    var viewfinderBorderColor: Color by mutableStateOf(viewfinderBorderColor)
        private set
    var primaryBlueButtonBackgroundColor: Color by mutableStateOf(primaryBlueButtonBackgroundColor)
        private set
    var primaryBlueButtonCharacterColor: Color by mutableStateOf(primaryBlueButtonCharacterColor)
        private set
    var primaryBlueButtonBorderColor: Color by mutableStateOf(primaryBlueButtonBorderColor)
        private set
    var secondaryBlueButtonBackgroundColor: Color by mutableStateOf(
        secondaryBlueButtonBackgroundColor
    )
        private set
    var secondaryBlueButtonCharacterColor: Color by mutableStateOf(secondaryBlueButtonCharacterColor)
        private set
    var secondaryBlueButtonBorderColor: Color by mutableStateOf(secondaryBlueButtonBorderColor)
        private set
    var yellowButtonBackgroundColor: Color by mutableStateOf(yellowButtonBackgroundColor)
        private set
    var yellowButtonCharacterColor: Color by mutableStateOf(yellowButtonCharacterColor)
        private set
    var yellowButtonBorderColor: Color by mutableStateOf(yellowButtonBorderColor)
        private set
    var rippleColor: Color by mutableStateOf(
        rippleColor
    )
        private set

    fun copy() = ColorScheme(
        appBackgroundColor,
        viewfinderBackgroundColor,
        viewfinderTextColor,
        viewfinderBorderColor,
        primaryBlueButtonBackgroundColor,
        primaryBlueButtonCharacterColor,
        primaryBlueButtonBorderColor,
        secondaryBlueButtonBackgroundColor,
        secondaryBlueButtonCharacterColor,
        secondaryBlueButtonBorderColor,
        yellowButtonBackgroundColor,
        yellowButtonCharacterColor,
        yellowButtonBorderColor,
        rippleColor
    )

    fun updateColorScheme(newColorScheme: ColorScheme) {
        this.appBackgroundColor = newColorScheme.appBackgroundColor
        this.viewfinderBackgroundColor = newColorScheme.viewfinderBackgroundColor
        this.viewfinderTextColor = newColorScheme.viewfinderTextColor
        this.viewfinderBorderColor = newColorScheme.viewfinderBorderColor
        this.primaryBlueButtonBackgroundColor = newColorScheme.primaryBlueButtonBackgroundColor
        this.primaryBlueButtonCharacterColor = newColorScheme.primaryBlueButtonCharacterColor
        this.primaryBlueButtonBorderColor = newColorScheme.primaryBlueButtonBorderColor
        this.secondaryBlueButtonBackgroundColor = newColorScheme.secondaryBlueButtonBackgroundColor
        this.secondaryBlueButtonCharacterColor = newColorScheme.secondaryBlueButtonCharacterColor
        this.secondaryBlueButtonBorderColor = newColorScheme.secondaryBlueButtonBorderColor
        this.yellowButtonBackgroundColor = newColorScheme.yellowButtonBackgroundColor
        this.yellowButtonCharacterColor = newColorScheme.yellowButtonCharacterColor
        this.yellowButtonBorderColor = newColorScheme.yellowButtonBorderColor
        this.rippleColor =
            newColorScheme.rippleColor
    }
}