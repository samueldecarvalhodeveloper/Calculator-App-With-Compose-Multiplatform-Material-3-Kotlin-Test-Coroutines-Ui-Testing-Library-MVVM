package org.example.calculatorapp.components.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.example.calculatorapp.infrastructure.UserInterfaceSpecifications.isScreenHeightSmall

@Composable
fun Keyboard(screenHeight: Dp, content: @Composable () -> Unit) {
    Column(
        KeyboardModifier
            .padding(
                top = if (isScreenHeightSmall(screenHeight)) 16.dp else 32.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = if (isScreenHeightSmall(screenHeight)) 4.dp else 8.dp
            )
    ) {
        content()
    }
}