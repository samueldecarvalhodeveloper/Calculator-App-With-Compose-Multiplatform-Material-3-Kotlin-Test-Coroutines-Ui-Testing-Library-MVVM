package org.example.calculatorapp.components

import org.example.calculatorapp.domains.expression_evaluator.ExpressionEvaluator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.Test
import kotlin.test.assertEquals

class ExpressionEvaluatorTest {
    @Test
    fun testIfExpressionIsBeingEvaluated() {
        val expressionToBeEvaluated =
            ExpressionTokens.ONE.value + ExpressionTokens.ADDITION.value + ExpressionTokens.ONE.value

        val evaluatedExpression =
            ExpressionEvaluator.getEvaluatedExpression(expressionToBeEvaluated)

        assertEquals(ExpressionTokens.TWO.value.toDouble(), evaluatedExpression)
    }
}