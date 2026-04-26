package org.example.calculatorapp.user_interface.application

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import calculatorapp.composeapp.generated.resources.Res
import calculatorapp.composeapp.generated.resources.not_valid_expression_message
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.toSuspendSettings
import org.example.calculatorapp.dependency_injections.CalculatorViewModelFactory
import org.example.calculatorapp.dependency_injections.ThemeModeViewModelFactory
import org.example.calculatorapp.user_interface.screens.CalculatorScreen
import org.example.calculatorapp.user_interface.theme.Theme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalSettingsApi::class)
@Composable
@Preview
fun Application() {
    val keyValueDatabaseImplementation = remember { Settings().toSuspendSettings() }
    val notValidExpressionMessage = stringResource(Res.string.not_valid_expression_message)
    val calculatorViewModel = CalculatorViewModelFactory.getInstance(
        notValidExpressionMessage,
        keyValueDatabaseImplementation
    )
    val themeModeViewModel = ThemeModeViewModelFactory.getInstance(keyValueDatabaseImplementation)

    Theme(themeModeViewModel.themeMode.value) {
        BoxWithConstraints {
            CalculatorScreen(calculatorViewModel, themeModeViewModel, maxHeight)
        }
    }
}