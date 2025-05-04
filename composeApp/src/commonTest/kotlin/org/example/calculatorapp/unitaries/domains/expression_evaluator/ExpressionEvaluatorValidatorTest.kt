package org.example.calculatorapp.unitaries.domains.expression_evaluator

import org.example.calculatorapp.constants.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.domains.expression_evaluator.ExpressionEvaluatorValidator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
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