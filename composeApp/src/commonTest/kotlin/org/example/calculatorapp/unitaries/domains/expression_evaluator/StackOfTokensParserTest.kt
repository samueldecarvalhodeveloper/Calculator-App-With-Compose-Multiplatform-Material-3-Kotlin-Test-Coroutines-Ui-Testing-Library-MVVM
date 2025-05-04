package org.example.calculatorapp.unitaries.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.domains.expression_evaluator.StackOfTokensParser
import kotlin.test.Test
import kotlin.test.assertEquals

class StackOfTokensParserTest {
    @Test
    fun testIfMethodParseStacksEvaluatesExpressionOnExpressionOnStacksFromBagOfTokens() {
        val stackOfOperands = mutableListOf<Double>()
        val stackOfOperators = mutableListOf<String>()
        val bagOfTokens = listOf(
            ExpressionTokens.ONE.value,
            ExpressionTokens.ADDITION.value,
            ExpressionTokens.ONE.value
        )

        StackOfTokensParser.parseStacks(stackOfOperands, stackOfOperators, bagOfTokens)

        assertEquals(ExpressionTokens.TWO.value.toDouble(), stackOfOperands.first())
    }
}