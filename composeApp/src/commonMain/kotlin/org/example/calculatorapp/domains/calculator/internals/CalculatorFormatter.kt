package org.example.calculatorapp.domains.calculator.internals

import org.example.calculatorapp.domains.calculator.internals.CalculatorChecker.isCalculationExpressionRationalNumber

object CalculatorFormatter {
    fun getExpressionWithoutLastCharacter(expression: String): String {
        return expression.dropLast(1)
    }

    fun getFixedEvaluatedExpression(evaluatedExpression: Double): String {
        return if (isCalculationExpressionRationalNumber(evaluatedExpression))
            evaluatedExpression.toString()
        else evaluatedExpression.toInt().toString()
    }
}