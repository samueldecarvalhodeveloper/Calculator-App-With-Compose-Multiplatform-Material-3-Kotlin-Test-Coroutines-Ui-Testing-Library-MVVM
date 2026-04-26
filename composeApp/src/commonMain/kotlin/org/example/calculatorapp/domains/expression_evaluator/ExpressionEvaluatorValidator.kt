package org.example.calculatorapp.domains.expression_evaluator

object ExpressionEvaluatorValidator {
    fun validateIfEvaluationOfAllTokensEnded(stackOfOperators: List<String>) {
        if (stackOfOperators.isNotEmpty()) {
            throw NotValidExpressionException()
        }
    }
}