package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.infrastructure.exceptions.NotValidExpressionException

object ArithmeticParser {
    fun parseExpressionArithmetic(
        firstOperand: Double,
        operator: String,
        secondOperand: Double
    ): Double {
        return when (operator) {
            ExpressionTokens.ADDITION.value -> firstOperand + secondOperand

            ExpressionTokens.SUBTRACTION.value -> firstOperand - secondOperand

            ExpressionTokens.MULTIPLICATION.value -> firstOperand * secondOperand

            ExpressionTokens.DIVISION.value -> ExecuteDivisionOperationAdapter.getResult(
                firstOperand,
                secondOperand
            )

            else -> throw NotValidExpressionException()
        }
    }
}