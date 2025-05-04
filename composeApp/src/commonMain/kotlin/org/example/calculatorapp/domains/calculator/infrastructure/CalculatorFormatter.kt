package org.example.calculatorapp.domains.calculator.infrastructure

object CalculatorFormatter {
    fun getCalculationExpressionWithoutLastCharacter(calculationExpression: String): String {
        return calculationExpression.substring(0, calculationExpression.length - 1)
    }
}