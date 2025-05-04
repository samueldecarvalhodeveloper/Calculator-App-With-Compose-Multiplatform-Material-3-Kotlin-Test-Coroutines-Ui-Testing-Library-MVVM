package org.example.calculatorapp.components.viewfinder

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.calculatorapp.infrastructure.UserInterfaceSpecifications.isScreenHeightSmall
import org.example.calculatorapp.theme.Theme

@Composable
fun Viewfinder(value: String, screenHeight: Dp, scrollState: ScrollState) {
    Box(
        modifier = Modifier
            .background(
                Theme.colors.viewfinderBorderColor,
                RoundedCornerShape(0.dp, 0.dp, 28.dp, 28.dp)
            )
            .fillMaxWidth()
            .padding(
                start = 1.dp,
                end = 1.dp,
                top = 0.dp,
                bottom = 1.dp,
            )
    ) {
        Box(
            modifier = Modifier
                .background(
                    Theme.colors.viewfinderBackgroundColor,
                    RoundedCornerShape(0.dp, 0.dp, 28.dp, 28.dp)
                )
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = if (isScreenHeightSmall(screenHeight)) 0.dp else 120.dp,
                    bottom = if (isScreenHeightSmall(screenHeight)) 0.dp else 16.dp,
                ),
            contentAlignment = Alignment.BottomEnd
        ) {
            BasicText(
                text = value,
                style = TextStyle(
                    fontSize = if (isScreenHeightSmall(screenHeight)) 42.sp else 52.sp,
                    fontWeight = FontWeight.Medium,
                    color = Theme.colors.viewfinderTextColor
                ),
                modifier = Modifier
                    .height(64.dp)
                    .horizontalScroll(
                        state = scrollState,
                    )
            )
        }
    }
}