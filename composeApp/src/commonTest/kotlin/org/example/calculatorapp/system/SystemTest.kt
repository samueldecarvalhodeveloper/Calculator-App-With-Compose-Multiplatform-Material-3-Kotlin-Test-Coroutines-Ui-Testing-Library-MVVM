package org.example.calculatorapp.system

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import calculatorapp.composeapp.generated.resources.Res
import calculatorapp.composeapp.generated.resources.actionbar_menu_toggle_night_mode_content_description
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import org.example.calculatorapp.constants.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT
import org.example.calculatorapp.domains.calculator.CalculationExpression
import org.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import org.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.screens.CalculatorScreen
import org.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import org.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import org.example.calculatorapp.view_models.CalculatorViewModel
import org.example.calculatorapp.view_models.ThemeModeViewModel
import org.jetbrains.compose.resources.stringResource
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@OptIn(ExperimentalSettingsApi::class)
class SystemTest {
    private lateinit var calculatorViewModel: CalculatorViewModel
    private lateinit var calculationExpressionStore: CalculationExpressionStore
    private lateinit var themeModeViewModel: ThemeModeViewModel
    private lateinit var userInterfaceThemeStore: UserInterfaceThemeStore

    @BeforeTest
    fun beforeEach() {
        runBlocking {
            val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
            val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)
            calculationExpressionStore = CalculationExpressionStore(keyValueDatabase)
            val storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()
            val calculationExpression = CalculationExpression(storedCalculationExpression)
            val calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
            val calculationExpressionActiveRecord =
                CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
            val calculator = Calculator(calculationExpressionActiveRecord)
            userInterfaceThemeStore = UserInterfaceThemeStore(keyValueDatabase)

            calculatorViewModel = CalculatorViewModel(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, calculator, calculationExpressionStore
            )
            themeModeViewModel = ThemeModeViewModel(true, userInterfaceThemeStore)
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfCalculationIsExecutedAndIsStoredOnKeyValueDatabase() = runComposeUiTest {
        setContent {
            CalculatorScreen(
                calculatorViewModel = calculatorViewModel,
                themeModeViewModel = themeModeViewModel,
                screenHeight = SMALL_SCREEN_HEIGHT
            )
        }

        calculatorViewModel.addCharacter(ExpressionTokens.ONE)
        calculatorViewModel.addCharacter(ExpressionTokens.ADDITION)
        calculatorViewModel.addCharacter(ExpressionTokens.ONE)

        onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value).assertExists()
        onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value).performClick()

        runBlocking {
            val storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()

            assertEquals(
                EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
                calculatorViewModel.calculationExpression.value
            )

            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression)
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfThemeModeIsToggledAndThemeModeIsStoredOnKeyValueDatabase() = runComposeUiTest {
        lateinit var actionbarMenuToggleNightModeContentDescription: String

        setContent {
            actionbarMenuToggleNightModeContentDescription =
                stringResource(Res.string.actionbar_menu_toggle_night_mode_content_description)

            CalculatorScreen(
                calculatorViewModel = calculatorViewModel,
                themeModeViewModel = themeModeViewModel,
                screenHeight = SMALL_SCREEN_HEIGHT
            )
        }

        val themeModeBeforeToggled = themeModeViewModel.themeMode.value

        onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription).assertExists()
        onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription).performClick()

        assertNotEquals(themeModeBeforeToggled, themeModeViewModel.themeMode.value)
    }
}