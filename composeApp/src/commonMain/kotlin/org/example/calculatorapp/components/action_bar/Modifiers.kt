package org.example.calculatorapp.components.action_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val actionBarContainerModifier = Modifier
    .fillMaxWidth()
    .padding(16.dp, 0.dp)
    .statusBarsPadding()

val actionBarActionButtonModifier = Modifier
    .height(64.dp)
    .size(48.dp)