package org.example.calculatorapp.unitaries.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.domains.expression_evaluator.TokensEvaluator
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TokensEvaluatorTest {
    @Test
    fun testIfMethodEvaluateTokensEvaluatesExpressionOnStacksOfTokens() {
        val stackOfOperands = mutableListOf(
            ExpressionTokens.ONE.value.toDouble(),
            ExpressionTokens.ONE.value.toDouble()
        )
        val stackOfOperators = mutableListOf(
            ExpressionTokens.ADDITION.value
        )

        TokensEvaluator.evaluateTokens(stackOfOperands, stackOfOperators)

        assertEquals(ExpressionTokens.TWO.value.toDouble(), stackOfOperands.first())
        assertTrue(stackOfOperators.isEmpty())
    }
}