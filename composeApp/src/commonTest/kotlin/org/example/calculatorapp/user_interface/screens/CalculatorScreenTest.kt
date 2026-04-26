package org.example.calculatorapp.user_interface.screens

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
import org.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_EXPRESSION
import org.example.calculatorapp.constants.domains.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import org.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import org.example.calculatorapp.user_interface.data_stores.ExpressionDataStore
import org.example.calculatorapp.user_interface.data_stores.ThemeDataStore
import org.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import org.example.calculatorapp.user_interface.view_models.ThemeModeViewModel
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
            val expressionDataStore = ExpressionDataStore(keyValueDatabase)
            val storedExpression = expressionDataStore.getStoredExpression()
            val calculator = Calculator(storedExpression)
            val themeDataStore = ThemeDataStore(keyValueDatabase)

            calculatorViewModel = CalculatorViewModel(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                calculator,
                expressionDataStore
            )
            themeModeViewModel = ThemeModeViewModel(true, themeDataStore)
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

            onNodeWithText(CalculatorCharacters.ZERO.value).assertExists()
            onNodeWithText(CalculatorCharacters.ONE.value).assertExists()
            onNodeWithText(CalculatorCharacters.TWO.value).assertExists()
            onNodeWithText(CalculatorCharacters.THREE.value).assertExists()
            onNodeWithText(CalculatorCharacters.FOUR.value).assertExists()
            onNodeWithText(CalculatorCharacters.FIVE.value).assertExists()
            onNodeWithText(CalculatorCharacters.SIX.value).assertExists()
            onNodeWithText(CalculatorCharacters.SEVEN.value).assertExists()
            onNodeWithText(CalculatorCharacters.EIGHT.value).assertExists()
            onNodeWithText(CalculatorCharacters.NINE.value).assertExists()

            onNodeWithText(CalculatorCharacters.ZERO.value).performClick()

            assertEquals(
                CalculatorCharacters.ZERO.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.ONE.value).performClick()

            assertEquals(
                CalculatorCharacters.ONE.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.TWO.value).performClick()

            assertEquals(
                CalculatorCharacters.TWO.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.THREE.value).performClick()

            assertEquals(
                CalculatorCharacters.THREE.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.FOUR.value).performClick()


            assertEquals(
                CalculatorCharacters.FOUR.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.FIVE.value).performClick()

            assertEquals(
                CalculatorCharacters.FIVE.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.SIX.value).performClick()

            assertEquals(
                CalculatorCharacters.SIX.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.SEVEN.value).performClick()

            assertEquals(
                CalculatorCharacters.SEVEN.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.EIGHT.value).performClick()

            assertEquals(
                CalculatorCharacters.EIGHT.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.NINE.value).performClick()

            assertEquals(
                CalculatorCharacters.NINE.value,
                calculatorViewModel.expression.value
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

            onNodeWithText(CalculatorCharacters.POINT.value).assertExists()
            onNodeWithText(CalculatorCharacters.POINT.value).performClick()


            assertEquals(
                CalculatorCharacters.POINT.value,
                calculatorViewModel.expression.value
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

            onNodeWithText(CalculatorCharacters.ADDITION.value)
                .assertExists()
            onNodeWithText(CalculatorCharacters.ADDITION.value)
                .performClick()

            assertEquals(
                CalculatorCharacters.ADDITION.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.SUBTRACTION.value)
                .assertExists()
            onNodeWithText(CalculatorCharacters.SUBTRACTION.value)
                .performClick()

            assertEquals(
                CalculatorCharacters.SUBTRACTION.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.MULTIPLICATION.value)
                .assertExists()
            onNodeWithText(CalculatorCharacters.MULTIPLICATION.value)
                .performClick()

            assertEquals(
                CalculatorCharacters.MULTIPLICATION.value,
                calculatorViewModel.expression.value
            )

            calculatorViewModel.clean()

            onNodeWithText(CalculatorCharacters.DIVISION.value)
                .assertExists()
            onNodeWithText(CalculatorCharacters.DIVISION.value)
                .performClick()

            assertEquals(
                CalculatorCharacters.DIVISION.value,
                calculatorViewModel.expression.value
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

        onNodeWithText(CalculatorCharacters.CLEAN.value)
            .assertExists()
        onNodeWithText(CalculatorCharacters.CLEAN.value)
            .performClick()

        assertEquals(
            "",
            calculatorViewModel.expression.value
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

        onNodeWithText(CalculatorCharacters.EVALUATION.value)
            .assertExists()
        onNodeWithText(CalculatorCharacters.EVALUATION.value)
            .performClick()

        assertEquals(
            EVALUATED_EXPRESSION,
            calculatorViewModel.expression.value
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