package org.example.calculatorapp.domains.calculator

import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionEmpty
import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

class CalculationExpressionActiveRecordDecorator(calculationExpressionRegister: CalculationExpressionRegister?) :
    CalculationExpressionActiveRecord(calculationExpressionRegister!!) {
    override fun addCharacterToCalculationExpression(character: ExpressionTokens) {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression)) {
            super.turnCalculationExpressionEmpty()
        } else {
            super.addCharacterToCalculationExpression(character)
        }
    }

    override fun removeLastCharacterFromCalculationExpression() {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression)) {
            super.turnCalculationExpressionEmpty()
        } else {
            super.removeLastCharacterFromCalculationExpression()
        }
    }

    override fun evaluateCalculationExpression() {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression) ||
            isCalculationExpressionEmpty(currentCalculationExpression)
        ) return

        super.evaluateCalculationExpression()
    }
}