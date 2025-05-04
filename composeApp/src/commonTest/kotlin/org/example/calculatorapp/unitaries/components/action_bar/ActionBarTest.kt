package org.example.calculatorapp.unitaries.components.action_bar

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import calculatorapp.composeapp.generated.resources.Res
import calculatorapp.composeapp.generated.resources.actionbar_menu_toggle_night_mode_content_description
import calculatorapp.composeapp.generated.resources.white_balance_sunny
import org.example.calculatorapp.components.action_bar.ActionBar
import org.jetbrains.compose.resources.stringResource
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class ActionBarTest {
    private var state = false

    @Test
    fun testIfComponentIsRenderedAndDispatchesItsEvent() = runComposeUiTest {
        lateinit var actionbarMenuToggleNightModeContentDescription: String

        setContent {
            actionbarMenuToggleNightModeContentDescription =
                stringResource(Res.string.actionbar_menu_toggle_night_mode_content_description)

            ActionBar(
                actionIconDrawableResource = Res.drawable.white_balance_sunny,
                actionContentDescriptionStringResource = Res.string.actionbar_menu_toggle_night_mode_content_description
            ) {
                state = !state
            }
        }


        onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        assertTrue(state)

        onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        assertFalse(state)
    }
}