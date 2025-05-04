package org.example.calculatorapp.unitaries.screens

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
class CalculatorScreenTest {
    private lateinit var calculatorViewModel: CalculatorViewModel
    private lateinit var themeModeViewModel: ThemeModeViewModel

    @BeforeTest
    fun beforeEach() {
        runBlocking {
            val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
            val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)
            val calculationExpressionStore = CalculationExpressionStore(keyValueDatabase)
            val storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()
            val calculationExpression = CalculationExpression(storedCalculationExpression)
            val calculationExpressionRegister =
                CalculationExpressionRegister(calculationExpression)
            val calculationExpressionActiveRecord =
                CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
            val calculator = Calculator(calculationExpressionActiveRecord)
            val userInterfaceThemeStore = UserInterfaceThemeStore(keyValueDatabase)

            calculatorViewModel = CalculatorViewModel(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                calculator,
                calculationExpressionStore
            )
            themeModeViewModel = ThemeModeViewModel(true, userInterfaceThemeStore)
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfAllNumericalCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() =
        runComposeUiTest {
            setContent {
                CalculatorScreen(
                    calculatorViewModel = calculatorViewModel,
                    themeModeViewModel = themeModeViewModel,
                    screenHeight = SMALL_SCREEN_HEIGHT
                )
            }

            onNodeWithText(UserInterfaceCalculatorCharacters.ZERO.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.TWO.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.THREE.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.FOUR.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.FIVE.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.SIX.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.SEVEN.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.EIGHT.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.NINE.value).assertExists()

            onNodeWithText(UserInterfaceCalculatorCharacters.ZERO.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.ZERO.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.ONE.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.TWO.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.TWO.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.THREE.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.THREE.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.FOUR.value).performClick()


            assertEquals(
                UserInterfaceCalculatorCharacters.FOUR.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.FIVE.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.FIVE.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.SIX.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.SIX.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.SEVEN.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.SEVEN.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.EIGHT.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.EIGHT.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.NINE.value).performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.NINE.value,
                calculatorViewModel.calculationExpression.value
            )
        }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfAllSymbolsCharactersIsSetAndDispatchesAddCharacterWithItsCharacter() =
        runComposeUiTest {
            setContent {
                CalculatorScreen(
                    calculatorViewModel = calculatorViewModel,
                    themeModeViewModel = themeModeViewModel,
                    screenHeight = SMALL_SCREEN_HEIGHT
                )
            }

            onNodeWithText(UserInterfaceCalculatorCharacters.POINT.value).assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.POINT.value).performClick()


            assertEquals(
                UserInterfaceCalculatorCharacters.POINT.value,
                calculatorViewModel.calculationExpression.value
            )
        }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfAllOperatorsCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() =
        runComposeUiTest {
            setContent {
                CalculatorScreen(
                    calculatorViewModel = calculatorViewModel,
                    themeModeViewModel = themeModeViewModel,
                    screenHeight = SMALL_SCREEN_HEIGHT
                )
            }

            onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value)
                .assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value)
                .performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.ADDITION.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.SUBTRACTION.value)
                .assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.SUBTRACTION.value)
                .performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.SUBTRACTION.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.MULTIPLICATION.value)
                .assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.MULTIPLICATION.value)
                .performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.MULTIPLICATION.value,
                calculatorViewModel.calculationExpression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(UserInterfaceCalculatorCharacters.DIVISION.value)
                .assertExists()
            onNodeWithText(UserInterfaceCalculatorCharacters.DIVISION.value)
                .performClick()

            assertEquals(
                UserInterfaceCalculatorCharacters.DIVISION.value,
                calculatorViewModel.calculationExpression.value
            )
        }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfAllClearCharactersIsSetAndDispatchesCleanViewModelMethod() = runComposeUiTest {
        setContent {
            CalculatorScreen(
                calculatorViewModel = calculatorViewModel,
                themeModeViewModel = themeModeViewModel,
                screenHeight = SMALL_SCREEN_HEIGHT
            )
        }

        calculatorViewModel.addCharacter(ExpressionTokens.ONE)

        onNodeWithText(UserInterfaceCalculatorCharacters.CLEAN.value)
            .assertExists()
        onNodeWithText(UserInterfaceCalculatorCharacters.CLEAN.value)
            .performClick()

        assertEquals(
            "",
            calculatorViewModel.calculationExpression.value
        )
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfAllEvaluateCharactersIsSetAndDispatchesEvaluateViewModelMethod() = runComposeUiTest {
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

        onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .assertExists()
        onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .performClick()

        assertEquals(
            EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
            calculatorViewModel.calculationExpression.value
        )
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testIfActionBarActionButtonTogglesThemeMode() = runComposeUiTest {
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

        onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .assertExists()
        onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()


        assertNotEquals(themeModeBeforeToggled, themeModeViewModel.themeMode.value)
    }
}