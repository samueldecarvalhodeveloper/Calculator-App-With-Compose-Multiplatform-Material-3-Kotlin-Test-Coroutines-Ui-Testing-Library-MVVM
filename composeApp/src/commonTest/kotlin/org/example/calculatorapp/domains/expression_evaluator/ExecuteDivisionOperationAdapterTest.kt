package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.constants.domains.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import kotlin.test.Test
import kotlin.test.assertEquals

class ExecuteDivisionOperationAdapterTest {
    @Test
    fun testIfMethodGetResultReturnsTheResultOfADivisionIfDivisorIsNotZeroOrThrowsNotValidExpressionExceptionIfDivisorIsZero() {
        val divisionResult = ExecuteDivisionOperationAdapter.getResult(
            ExpressionTokens.TWO.value.toDouble(),
            ExpressionTokens.TWO.value.toDouble()
        )

        assertEquals(ExpressionTokens.ONE.value.toDouble(), divisionResult)

        try {
            ExecuteDivisionOperationAdapter.getResult(
                ExpressionTokens.ZERO.value.toDouble(),
                ExpressionTokens.ZERO.value.toDouble()
            )
        } catch (exception: Exception) {
            assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, exception.message)
        }
    }
}
