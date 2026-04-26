package org.example.calculatorapp.dependency_injections

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import org.example.calculatorapp.user_interface.data_stores.ExpressionDataStore
import org.example.calculatorapp.user_interface.view_models.CalculatorViewModel

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
                val expressionDataStore = ExpressionDataStore(keyValueDatabase)
                val storedExpression =
                    expressionDataStore.getStoredExpression()
                val calculator = Calculator(storedExpression)

                instance = CalculatorViewModel(
                    notValidExpressionMessage,
                    calculator,
                    expressionDataStore
                )
            }
        }

        return instance
    }
}