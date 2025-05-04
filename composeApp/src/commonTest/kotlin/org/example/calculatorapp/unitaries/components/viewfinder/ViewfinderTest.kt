package org.example.calculatorapp.unitaries.components.viewfinder

import androidx.compose.foundation.ScrollState
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.example.calculatorapp.components.viewfinder.Viewfinder
import org.example.calculatorapp.constants.UserInterfaceConstants.INITIAL_VIEWFINDER_SCROLL_POSITION
import org.example.calculatorapp.constants.UserInterfaceConstants.LONG_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class ViewfinderTest {
    private val scrollState = ScrollState(INITIAL_VIEWFINDER_SCROLL_POSITION)

    @Test
    fun testIfComponentIsRenderedAndIsScrolled() = runComposeUiTest {
        setContent {
            Viewfinder(LONG_CALCULATION_EXPRESSION, SMALL_SCREEN_HEIGHT, scrollState)

        }

        onNodeWithText(LONG_CALCULATION_EXPRESSION).assert(hasScrollAction())
    }
}