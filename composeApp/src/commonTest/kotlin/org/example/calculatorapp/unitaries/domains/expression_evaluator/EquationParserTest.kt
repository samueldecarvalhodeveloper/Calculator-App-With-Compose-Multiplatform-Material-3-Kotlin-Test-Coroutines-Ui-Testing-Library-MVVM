package org.example.calculatorapp.unitaries.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.EquationParser
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.Test
import kotlin.test.assertEquals

class EquationParserTest {
    @Test
    fun testIfMethodParseEquationAddTokenToStackOfOperatorsIfTokenIsAnOperatorOrEvaluatesExpressionIfTokenIsNotAnOperator() {
        val stackOfOperands = mutableListOf(ExpressionTokens.ONE.value.toDouble())
        val stackOfOperators = mutableListOf<String>()

        EquationParser.parseEquation(
            stackOfOperands,
            stackOfOperators,
            ExpressionTokens.ADDITION.value
        )

        assertEquals(ExpressionTokens.ADDITION.value, stackOfOperators.first())

        EquationParser.parseEquation(
            stackOfOperands,
            stackOfOperators,
            ExpressionTokens.ONE.value
        )

        assertEquals(ExpressionTokens.TWO.value, stackOfOperands.first().toInt().toString())
    }
}