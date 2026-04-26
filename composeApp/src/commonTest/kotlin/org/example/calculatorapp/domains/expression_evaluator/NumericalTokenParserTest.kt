package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.constants.domains.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import kotlin.test.Test
import kotlin.test.assertEquals

class NumericalTokenParserTest {
    @Test
    fun testIfMethodGetParsedTokenReturnsTheNumericalTokenParsedToken() {
        val parsedNumericalToken = NumericalTokenParser.getParsedToken(ExpressionTokens.ONE.value)

        assertEquals(ExpressionTokens.ONE.value.toDouble(), parsedNumericalToken)

        try {
            NumericalTokenParser.getParsedToken(ExpressionTokens.ADDITION.value)
        } catch (exception: Exception) {
            assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, exception.message)
        }
    }
}