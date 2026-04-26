package org.example.calculatorapp.domains.calculator

import org.example.calculatorapp.domains.calculator.internals.CalculatorFormatter
import org.example.calculatorapp.domains.expression_evaluator.ExpressionEvaluator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

class Calculator(expression: String) {
    var expression: String = expression
        private set

    fun addCharacter(characters: ExpressionTokens) {
        expression += characters.value
    }

    fun backspace() {
        expression = CalculatorFormatter.getExpressionWithoutLastCharacter(
            expression
        )
    }

    fun clean() {
        expression = ""
    }

    fun evaluate() {
        try {
            val evaluatedExpression = ExpressionEvaluator.getEvaluatedExpression(expression)

            expression = CalculatorFormatter.getFixedEvaluatedExpression(evaluatedExpression)
        } catch (exception: Exception) {
            expression = ""

            throw exception
        }
    }
}