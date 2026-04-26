package org.example.calculatorapp.user_interface.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.user_interface.data_stores.ExpressionDataStore

open class CalculatorViewModel(
    private val notValidExpressionMessageOnDeviceLanguage: String,
    private val calculator: Calculator,
    private val expressionDataStore: ExpressionDataStore,
    private var suspendedFunctionContext: ((suspend () -> Unit) -> Unit)? = null
) : ViewModel() {
    private var _expression = mutableStateOf(calculator.expression)
    val expression: State<String> = _expression

    init {
        if(suspendedFunctionContext == null) {
            suspendedFunctionContext = {
                viewModelScope.launch {
                    it()
                }
            }
        }
    }

    open fun addCharacter(calculatorCharacters: ExpressionTokens) {
        calculator.addCharacter(calculatorCharacters)

        _expression.value = calculator.expression

        suspendedFunctionContext?.invoke {
            expressionDataStore.setStoredExpression(calculator.expression)
        }
    }

    open fun backspace() {
        calculator.backspace()

        _expression.value = calculator.expression

        suspendedFunctionContext?.invoke{
            expressionDataStore.setStoredExpression(calculator.expression)
        }
    }

    open fun clean() {
        calculator.clean()

        _expression.value = calculator.expression

        suspendedFunctionContext?.invoke{
            expressionDataStore.setStoredExpression(calculator.expression)
        }
    }

    open fun evaluate() {
        try {
            calculator.evaluate()

            _expression.value = calculator.expression
        } catch (_: Exception) {
            _expression.value = notValidExpressionMessageOnDeviceLanguage
        }

        suspendedFunctionContext?.invoke{
            expressionDataStore.setStoredExpression(calculator.expression)
        }
    }
}