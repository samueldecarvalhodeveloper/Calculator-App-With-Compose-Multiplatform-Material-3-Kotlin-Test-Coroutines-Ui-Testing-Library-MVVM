package org.example.calculatorapp.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

val lightModeTheme =
    ColorScheme(
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

val darkModeTheme =
    ColorScheme(
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

val LocalColorScheme = staticCompositionLocalOf { lightModeTheme }

object Theme {
    val colors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current
}


@Composable
fun Theme(
    isThemeDark: Boolean,
    content: @Composable () -> Unit
) {
    val currentColorScheme =
        if (isThemeDark) darkModeTheme else lightModeTheme

    val rememberColor = remember {
        currentColorScheme.copy()
    }.apply { updateColorScheme(currentColorScheme) }

    CompositionLocalProvider(LocalColorScheme provides rememberColor) {
        content()
    }
}