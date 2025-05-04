package org.example.calculatorapp.domains.calculator

import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionEmpty
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

class Calculator(private val calculatorExpressionActiveRecord: CalculationExpressionActiveRecord) {
    fun getCalculationExpression(): String {
        return calculatorExpressionActiveRecord.getCalculationExpression()
    }

    fun addCharacter(calculatorCharacters: ExpressionTokens) {
        calculatorExpressionActiveRecord.addCharacterToCalculationExpression(calculatorCharacters)
    }

    fun backspace() {
        val currentCalculationExpression =
            calculatorExpressionActiveRecord.getCalculationExpression()

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return

        calculatorExpressionActiveRecord.removeLastCharacterFromCalculationExpression()
    }

    fun clean() {
        val currentCalculationExpression =
            calculatorExpressionActiveRecord.getCalculationExpression()

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return

        calculatorExpressionActiveRecord.turnCalculationExpressionEmpty()
    }

    fun evaluate() {
        val currentCalculationExpression =
            calculatorExpressionActiveRecord.getCalculationExpression()

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return

        calculatorExpressionActiveRecord.evaluateCalculationExpression()
    }
}