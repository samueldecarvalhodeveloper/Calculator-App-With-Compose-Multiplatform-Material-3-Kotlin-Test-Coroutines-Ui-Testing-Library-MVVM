package org.example.calculatorapp.user_interface.view_models

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.example.calculatorapp.constants.domains.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import org.example.calculatorapp.user_interface.data_stores.ExpressionDataStore
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSettingsApi::class)
class CalculatorViewModelTest {
    lateinit var calculatorViewModel: CalculatorViewModel
    lateinit var expressionDataStore: ExpressionDataStore
    lateinit var calculator: Calculator

    @BeforeTest
    fun beforeEach() {
        val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
        val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)

        calculator = Calculator("")

        expressionDataStore = ExpressionDataStore(keyValueDatabase)

        calculatorViewModel = CalculatorViewModel(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
            calculator,
            expressionDataStore
        ) {
            runBlocking { it() }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodAddCharacterAddsCharacterToExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)

            assertEquals(
                ExpressionTokens.ONE.value,
                calculatorViewModel.expression.value
            )

            val storedExpression =
                expressionDataStore.getStoredExpression()

            assertEquals(
                ExpressionTokens.ONE.value,
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(ExpressionTokens.ONE)
            calculator.addCharacter(ExpressionTokens.ONE)

            calculatorViewModel.backspace()

            advanceUntilIdle()

            assertEquals(
                ExpressionTokens.ONE.value,
                calculatorViewModel.expression.value
            )

            val storedExpression =
                expressionDataStore.getStoredExpression()

            assertEquals(
                ExpressionTokens.ONE.value,
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodCleanRemovesAllCharactersFromExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(ExpressionTokens.ONE)
            calculator.addCharacter(ExpressionTokens.ONE)

            calculatorViewModel.clean()

            advanceUntilIdle()

            assertEquals(
                "",
                calculatorViewModel.expression.value
            )

            val storedExpression =
                expressionDataStore.getStoredExpression()

            assertEquals(
                "",
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodEvaluateEvaluatesExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(ExpressionTokens.ONE)
            calculator.addCharacter(ExpressionTokens.ADDITION)
            calculator.addCharacter(ExpressionTokens.ONE)

            calculatorViewModel.evaluate()

            advanceUntilIdle()

            assertEquals(
                ExpressionTokens.TWO.value,
                calculatorViewModel.expression.value
            )

            val storedExpression =
                expressionDataStore.getStoredExpression()

            assertEquals(
                ExpressionTokens.TWO.value,
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodEvaluateTurnsUserInterfaceExpressionToNotValidExpressionMessageOnDeviceLanguageAndCalculatorExpressionStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(ExpressionTokens.ONE)
            calculator.addCharacter(ExpressionTokens.ADDITION)

            calculatorViewModel.evaluate()

            advanceUntilIdle()

            assertEquals(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                calculatorViewModel.expression.value
            )

            val storedExpression =
                expressionDataStore.getStoredExpression()

            assertEquals(
                "",
                storedExpression
            )
        }
}