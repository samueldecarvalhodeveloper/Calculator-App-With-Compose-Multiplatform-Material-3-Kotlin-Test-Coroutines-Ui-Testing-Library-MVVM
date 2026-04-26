package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.constants.domains.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import kotlin.test.Test
import kotlin.test.assertEquals

class ExpressionEvaluatorValidatorTest {
    @Test
    fun testIfMethodValidateIfEvaluationOfAllTokensEndedValidatesIfEvaluationOfAllOperatorTokensIsDone() {
        try {
            ExpressionEvaluatorValidator.validateIfEvaluationOfAllTokensEnded(
                listOf(ExpressionTokens.ADDITION.value)
            )
        } catch (exception: Exception) {
            assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, exception.message)
        }
    }
}