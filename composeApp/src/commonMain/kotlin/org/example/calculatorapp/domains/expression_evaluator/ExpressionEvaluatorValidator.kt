package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.infrastructure.exceptions.NotValidExpressionException

object ExpressionEvaluatorValidator {
    fun validateIfEvaluationOfAllTokensEnded(stackOfOperators: List<String>) {
        if (stackOfOperators.isNotEmpty()) {
            throw NotValidExpressionException()
        }
    }
}