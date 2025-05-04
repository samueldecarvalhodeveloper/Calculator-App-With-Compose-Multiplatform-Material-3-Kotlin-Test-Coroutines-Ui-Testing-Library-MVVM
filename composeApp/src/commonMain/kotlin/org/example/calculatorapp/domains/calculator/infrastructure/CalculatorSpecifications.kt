package org.example.calculatorapp.domains.calculator.infrastructure

import org.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE

object CalculatorSpecifications {
    fun isCalculationExpressionRationalNumber(evaluatedCalculationExpression: Double): Boolean {
        return evaluatedCalculationExpression != evaluatedCalculationExpression.toInt().toDouble()
    }

    fun isCalculationExpressionEmpty(calculationExpression: String): Boolean {
        return calculationExpression == ""
    }

    fun isCalculationExpressionNotValidExpressionExceptionMessage(calculationExpression: String): Boolean {
        return calculationExpression == NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
    }
}