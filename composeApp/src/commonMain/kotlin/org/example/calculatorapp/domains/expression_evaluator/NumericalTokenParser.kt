package org.example.calculatorapp.domains.expression_evaluator

object NumericalTokenParser {
    fun getParsedToken(token: String): Double {
        return try {
            token.toDouble()
        } catch (_: NumberFormatException) {
            throw NotValidExpressionException()
        }
    }
}