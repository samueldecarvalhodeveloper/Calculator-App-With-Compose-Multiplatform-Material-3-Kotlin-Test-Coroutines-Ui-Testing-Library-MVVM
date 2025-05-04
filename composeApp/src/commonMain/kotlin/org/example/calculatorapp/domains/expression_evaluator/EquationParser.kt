package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.infrastructure.ExpressionEvaluatorSpecifications.isTokenAnOperator

object EquationParser {
    fun parseEquation(
        stackOfOperands: MutableList<Double>,
        stackOfOperators: MutableList<String>,
        token: String
    ) {
        if (isTokenAnOperator(token)) {
            stackOfOperators.add(token)
        } else {
            val parsedNumericalToken = NumericalTokenParser.getParsedToken(token)

            stackOfOperands.add(parsedNumericalToken)

            TokensEvaluator.evaluateTokens(stackOfOperands, stackOfOperators)
        }
    }
}