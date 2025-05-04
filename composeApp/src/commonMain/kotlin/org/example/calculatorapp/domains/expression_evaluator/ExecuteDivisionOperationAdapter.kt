package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.infrastructure.ExpressionEvaluatorSpecifications.isDivisorZero
import org.example.calculatorapp.domains.expression_evaluator.infrastructure.exceptions.NotValidExpressionException

object ExecuteDivisionOperationAdapter {
    fun getResult(dividend: Double, divisor: Double): Double {
        if (isDivisorZero(divisor)) {
            throw NotValidExpressionException()
        } else {
            return dividend / divisor
        }
    }
}