package org.example.calculatorapp.components.button

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

val buttonBorderContainerModifier = Modifier
    .fillMaxSize()
    .clip(shape = RoundedCornerShape(28.dp))

val buttonBackgroundContainerModifier = Modifier
    .fillMaxSize()
    .clip(shape = RoundedCornerShape(28.dp))