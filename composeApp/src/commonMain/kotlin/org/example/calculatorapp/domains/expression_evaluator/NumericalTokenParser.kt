package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.infrastructure.exceptions.NotValidExpressionException

object NumericalTokenParser {
    fun getParsedToken(token: String): Double {
        return try {
            token.toDouble()
        } catch (_: NumberFormatException) {
            throw NotValidExpressionException()
        }
    }
}