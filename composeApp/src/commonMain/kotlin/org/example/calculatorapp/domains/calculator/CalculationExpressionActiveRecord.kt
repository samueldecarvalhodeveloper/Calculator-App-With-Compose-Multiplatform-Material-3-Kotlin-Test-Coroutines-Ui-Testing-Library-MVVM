package org.example.calculatorapp.domains.calculator

import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorFormatter
import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionRationalNumber
import org.example.calculatorapp.domains.expression_evaluator.ExpressionEvaluator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

open class CalculationExpressionActiveRecord(private val calculationExpressionRegister: CalculationExpressionRegister) {
    open fun getCalculationExpression(): String {
        return calculationExpressionRegister.getCalculationExpression()
    }

    open fun addCharacterToCalculationExpression(character: ExpressionTokens) {
        calculationExpressionRegister.addCharacterToCalculationExpression(character)
    }

    open fun removeLastCharacterFromCalculationExpression() {
        val currentCalculationExpression = calculationExpressionRegister.getCalculationExpression()
        val currentCalculationExpressionWithoutLastCharacter =
            CalculatorFormatter.getCalculationExpressionWithoutLastCharacter(
                currentCalculationExpression
            )

        calculationExpressionRegister.setCalculationExpression(
            currentCalculationExpressionWithoutLastCharacter
        )
    }

    open fun turnCalculationExpressionEmpty() {
        calculationExpressionRegister.setCalculationExpression("")
    }

    open fun evaluateCalculationExpression() {
        val currentCalculationExpression = calculationExpressionRegister.getCalculationExpression()

        val evaluatedCalculationExpression =
            ExpressionEvaluator.getEvaluatedExpression(currentCalculationExpression)

        val formattedEvaluatedCalculationExpression =
            if (isCalculationExpressionRationalNumber(evaluatedCalculationExpression))
                evaluatedCalculationExpression.toString()
            else
                evaluatedCalculationExpression.toInt().toString()

        calculationExpressionRegister.setCalculationExpression(
            formattedEvaluatedCalculationExpression
        )
    }
}