package org.example.calculatorapp.infrastructure.factories

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import org.example.calculatorapp.domains.calculator.CalculationExpression
import org.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import org.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.view_models.CalculatorViewModel

object CalculatorViewModelFactory {
    private lateinit var instance: CalculatorViewModel

    @OptIn(ExperimentalSettingsApi::class)
    fun getInstance(
        notValidExpressionMessage: String,
        keyValueDatabaseImplementation: SuspendSettings
    ): CalculatorViewModel {
        if (this::instance.isInitialized.not()) {
            runBlocking {
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

                instance = CalculatorViewModel(
                    notValidExpressionMessage,
                    calculator,
                    calculationExpressionStore
                )
            }
        }

        return instance
    }
}