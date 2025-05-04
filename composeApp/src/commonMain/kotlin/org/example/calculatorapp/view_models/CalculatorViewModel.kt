package org.example.calculatorapp.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

open class CalculatorViewModel(
    private val notValidExpressionMessage: String,
    private val calculator: Calculator,
    private val calculationExpressionStore: CalculationExpressionStore
) : ViewModel() {
    private var _calculationExpression = mutableStateOf<String>("")
    val calculationExpression: State<String>
        get() {
            _calculationExpression.value =
                if (isCalculationExpressionNotValidExpressionExceptionMessage(
                        _calculationExpression.value
                    )
                ) notValidExpressionMessage else _calculationExpression.value

            return _calculationExpression
        }

    init {
        val initialExpression = calculator.getCalculationExpression()

        _calculationExpression.value = initialExpression
    }

    open fun addCharacter(calculatorCharacters: ExpressionTokens) {
        viewModelScope.launch {
            calculator.addCharacter(calculatorCharacters)

            val currentCalculationExpression = calculator.getCalculationExpression()

            _calculationExpression.value = currentCalculationExpression

            calculationExpressionStore.setStoredCalculationExpression(currentCalculationExpression)
        }
    }

    open fun backspace() {
        viewModelScope.launch {
            calculator.backspace()

            val currentCalculationExpression = calculator.getCalculationExpression()

            _calculationExpression.value = currentCalculationExpression

            calculationExpressionStore.setStoredCalculationExpression(currentCalculationExpression)
        }
    }

    open fun clean() {
        viewModelScope.launch {
            calculator.clean()

            val currentCalculationExpression = calculator.getCalculationExpression()

            _calculationExpression.value = currentCalculationExpression

            calculationExpressionStore.setStoredCalculationExpression(currentCalculationExpression)
        }
    }

    open fun evaluate() {
        viewModelScope.launch {
            calculator.evaluate()

            val currentCalculationExpression = calculator.getCalculationExpression()

            _calculationExpression.value =
                if (isCalculationExpressionNotValidExpressionExceptionMessage(
                        currentCalculationExpression
                    )
                ) notValidExpressionMessage else currentCalculationExpression

            calculationExpressionStore.setStoredCalculationExpression(currentCalculationExpression)
        }
    }
}