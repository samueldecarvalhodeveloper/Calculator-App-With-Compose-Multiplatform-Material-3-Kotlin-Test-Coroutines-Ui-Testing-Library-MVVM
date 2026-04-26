package org.example.calculatorapp.domains.calculator.internals

object CalculatorChecker {
    fun isCalculationExpressionRationalNumber(evaluatedCalculationExpression: Double): Boolean {
        return evaluatedCalculationExpression != evaluatedCalculationExpression.toInt().toDouble()
    }
}