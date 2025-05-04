package org.example.calculatorapp.unitaries.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokenizer
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.Test
import kotlin.test.assertTrue

class ExpressionTokenizerTest {
    @Test
    fun testIfMethodGetTokensFromExpressionReturnsListOfTokensValidOnExpressionEvaluation() {
        val expressionToBeTokenized =
            ExpressionTokens.ONE.value + ExpressionTokens.ADDITION.value + ExpressionTokens.ONE.value

        val tokens = ExpressionTokenizer.getTokensFromExpression(expressionToBeTokenized)

        assertTrue(tokens.size == 3)
    }
}