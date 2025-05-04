package org.example.calculatorapp.unitaries.domains.expression_evaluator

import org.example.calculatorapp.constants.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.domains.expression_evaluator.ArithmeticParser
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.Test
import kotlin.test.assertEquals

class ArithmeticParserTest {
    @Test
    fun testIfMethodParseExpressionArithmeticReturnsTheEvaluatedResultFromArithmeticExpression() {
        val additionArithmeticExpressionResult =
            ArithmeticParser.parseExpressionArithmetic(
                ExpressionTokens.ONE.value.toDouble(),
                ExpressionTokens.ADDITION.value,
                ExpressionTokens.ONE.value.toDouble()
            )
        val subtractionArithmeticExpressionResult =
            ArithmeticParser.parseExpressionArithmetic(
                ExpressionTokens.TWO.value.toDouble(),
                ExpressionTokens.SUBTRACTION.value,
                ExpressionTokens.ONE.value.toDouble()
            )
        val multiplicationArithmeticExpressionResult =
            ArithmeticParser.parseExpressionArithmetic(
                ExpressionTokens.TWO.value.toDouble(),
                ExpressionTokens.MULTIPLICATION.value,
                ExpressionTokens.TWO.value.toDouble()
            )
        val divisionArithmeticExpressionResult =
            ArithmeticParser.parseExpressionArithmetic(
                ExpressionTokens.TWO.value.toDouble(),
                ExpressionTokens.DIVISION.value,
                ExpressionTokens.TWO.value.toDouble()
            )

        assertEquals(ExpressionTokens.TWO.value.toDouble(), additionArithmeticExpressionResult)
        assertEquals(ExpressionTokens.ONE.value.toDouble(), subtractionArithmeticExpressionResult)
        assertEquals(
            ExpressionTokens.FOUR.value.toDouble(),
            multiplicationArithmeticExpressionResult
        )
        assertEquals(ExpressionTokens.ONE.value.toDouble(), divisionArithmeticExpressionResult)

        try {
            ArithmeticParser.parseExpressionArithmetic(
                ExpressionTokens.TWO.value.toDouble(),
                ExpressionTokens.TWO.value,
                ExpressionTokens.TWO.value.toDouble()
            )
        } catch (exception: Exception) {
            assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, exception.message)
        }
    }
}