package org.example.calculatorapp.domains.calculator

import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

class CalculationExpressionRegister(
    private val calculationExpression: CalculationExpression
) {
    fun getCalculationExpression(): String {
        return calculationExpression.calculationExpression
    }

    fun setCalculationExpression(newExpression: String) {
        calculationExpression.calculationExpression = newExpression
    }

    fun addCharacterToCalculationExpression(calculatorCharacters: ExpressionTokens) {
        val currentCalculationExpression = calculationExpression.calculationExpression
        val calculationExpressionWithNewCharacter =
            currentCalculationExpression + calculatorCharacters.value

        calculationExpression.calculationExpression = calculationExpressionWithNewCharacter
    }
}