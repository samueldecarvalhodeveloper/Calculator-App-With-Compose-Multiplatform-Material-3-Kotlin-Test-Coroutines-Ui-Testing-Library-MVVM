package org.example.calculatorapp.unitaries.view_models

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import org.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.domains.calculator.CalculationExpression
import org.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import org.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.view_models.CalculatorViewModel
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


@OptIn(ExperimentalSettingsApi::class)
class CalculatorViewModelTest {
    lateinit var calculatorViewModel: CalculatorViewModel
    lateinit var calculationExpressionStore: CalculationExpressionStore
    val standardTestDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun beforeEach() {
        val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
        val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)
        val calculationExpression = CalculationExpression("")
        val calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
        val calculationExpressionActiveRecord =
            CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
        val calculator = Calculator(calculationExpressionActiveRecord)

        calculationExpressionStore = CalculationExpressionStore(keyValueDatabase)

        calculatorViewModel = CalculatorViewModel(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, calculator, calculationExpressionStore
        )

        Dispatchers.setMain(standardTestDispatcher)
    }

    @Test
    fun testIfCalculationExpressionStateReturnsNotValidCalculationExpressionMessageOnDeviceLanguage() =
        runTest {
            val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()
            val keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)
            val calculationExpressionStore = CalculationExpressionStore(keyValueDatabase)
            val calculationExpression =
                CalculationExpression(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE)
            val calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
            val calculationExpressionActiveRecord =
                CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
            val calculator = Calculator(calculationExpressionActiveRecord)

            calculatorViewModel = CalculatorViewModel(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, calculator, calculationExpressionStore
            )

            assertEquals(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                calculatorViewModel.calculationExpression.value
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodAddCharacterAddsCharacterToCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)

            advanceUntilIdle()

            assertEquals(
                ExpressionTokens.ONE.value,
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()

            assertEquals(
                ExpressionTokens.ONE.value,
                storedCalculationExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)

            calculatorViewModel.backspace()

            advanceUntilIdle()

            assertEquals(
                ExpressionTokens.ONE.value,
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()

            assertEquals(
                ExpressionTokens.ONE.value,
                storedCalculationExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodCleanRemovesAllCharactersFromCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)

            calculatorViewModel.clean()

            advanceUntilIdle()

            assertEquals(
                "",
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()

            assertEquals(
                "",
                storedCalculationExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodEvaluateEvaluatesCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)
            calculatorViewModel.addCharacter(ExpressionTokens.ADDITION)
            calculatorViewModel.addCharacter(ExpressionTokens.ONE)

            calculatorViewModel.evaluate()

            advanceUntilIdle()

            assertEquals(
                ExpressionTokens.TWO.value,
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()

            assertEquals(
                ExpressionTokens.TWO.value,
                storedCalculationExpression
            )
        }
}