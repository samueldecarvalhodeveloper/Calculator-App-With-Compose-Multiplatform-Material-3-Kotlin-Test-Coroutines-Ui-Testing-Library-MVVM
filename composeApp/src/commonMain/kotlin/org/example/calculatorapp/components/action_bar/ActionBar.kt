package org.example.calculatorapp.components.action_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.calculatorapp.theme.Theme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ActionBar(
    actionIconDrawableResource: DrawableResource,
    actionContentDescriptionStringResource: StringResource,
    onActionButtonClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .background(Theme.colors.viewfinderBackgroundColor)
            .then(actionBarContainerModifier),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = actionBarActionButtonModifier
                .clickable(
                    onClick = onActionButtonClick,
                    indication = ripple(
                        bounded = true,
                        color = Theme.colors.rippleColor,
                        radius = 24.dp
                    ),
                    interactionSource = interactionSource
                ), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(actionIconDrawableResource),
                contentDescription = stringResource(actionContentDescriptionStringResource)
            )
        }
    }
}
