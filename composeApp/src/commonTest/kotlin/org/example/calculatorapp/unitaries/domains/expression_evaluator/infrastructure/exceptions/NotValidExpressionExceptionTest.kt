package org.example.calculatorapp.unitaries.domains.expression_evaluator.infrastructure.exceptions

import org.example.calculatorapp.constants.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.domains.expression_evaluator.infrastructure.exceptions.NotValidExpressionException
import kotlin.test.Test
import kotlin.test.assertEquals

class NotValidExpressionExceptionTest {
    @Test
    fun testIfExceptionDescribesNotValidExpressionOnTheSystem() {
        try {
            throw NotValidExpressionException()
        } catch (exception: Exception) {
            assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, exception.message)
        }
    }
}