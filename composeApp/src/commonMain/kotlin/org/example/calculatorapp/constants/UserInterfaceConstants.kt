package org.example.calculatorapp.constants

import androidx.compose.ui.unit.dp

object UserInterfaceConstants {
    val SMALL_SCREEN_HEIGHT = 576.dp

    const val LAST_SESSION_CALCULATION_EXPRESSION_KEY = "calculationexpression"

    fun VIEWFINDER_VALUE_WIDTH(valueLength: Int) = valueLength * 64

    fun NOT_EXISTING_KEY_EXCEPTION_MESSAGE(key: String): String {
        return "Key: \"$key\"; Does Not Exist!"
    }

    const val THEME_KEY = "theme"

    val SMALLER_SCREEN_WIDTH = 320.dp

    val LARGER_SCREEN_WIDTH = 1920.dp

    const val INITIAL_VIEWFINDER_SCROLL_POSITION = 0

    const val LONG_CALCULATION_EXPRESSION =
        "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
}