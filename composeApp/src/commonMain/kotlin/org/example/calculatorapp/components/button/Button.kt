package org.example.calculatorapp.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.calculatorapp.infrastructure.UserInterfaceSpecifications.isScreenHeightSmall
import org.example.calculatorapp.theme.Theme
import org.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters

@Composable
fun Button(
    character: UserInterfaceCalculatorCharacters,
    characterColor: Color,
    backgroundColor: Color,
    borderColor: Color,
    screenHeight: Dp,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = buttonBorderContainerModifier
            .background(borderColor)
            .padding(1.dp)
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = ripple(
                    bounded = true,
                    color = Theme.colors.rippleColor,
                    radius = screenHeight
                )
            )
    ) {
        Box(
            modifier = buttonBackgroundContainerModifier
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            BasicText(
                text = character.value,
                style = TextStyle(
                    color = characterColor,
                    fontSize = if (isScreenHeightSmall(screenHeight)) 26.sp else 42.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}
