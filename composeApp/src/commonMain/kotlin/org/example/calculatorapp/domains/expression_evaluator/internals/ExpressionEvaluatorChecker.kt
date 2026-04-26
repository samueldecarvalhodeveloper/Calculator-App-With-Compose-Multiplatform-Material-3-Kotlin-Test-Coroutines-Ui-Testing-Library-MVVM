package org.example.calculatorapp.domains.expression_evaluator.internals

import org.example.calculatorapp.constants.domains.ExpressionEvaluatorConstants
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

object ExpressionEvaluatorChecker {
    fun isTokenAnOperator(token: String): Boolean =
        token == ExpressionTokens.ADDITION.value ||
                token == ExpressionTokens.SUBTRACTION.value ||
                token == ExpressionTokens.MULTIPLICATION.value ||
                token == ExpressionTokens.DIVISION.value

    fun isThereMoreArithmeticToBeDone(
        stackOfNumbers: MutableList<Double>,
        stackOfOperators: MutableList<String>
    ): Boolean =
        stackOfNumbers.size >= ExpressionEvaluatorConstants.EXPRESSION_WITH_TWO_OPERANDS && stackOfOperators.isNotEmpty()

    fun isDivisorZero(divisor: Double): Boolean = divisor == 0.0
}