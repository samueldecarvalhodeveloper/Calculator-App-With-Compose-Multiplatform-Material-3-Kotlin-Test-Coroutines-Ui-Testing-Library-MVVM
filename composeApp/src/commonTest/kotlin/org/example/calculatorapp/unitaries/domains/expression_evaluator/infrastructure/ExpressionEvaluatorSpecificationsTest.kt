package org.example.calculatorapp.unitaries.domains.expression_evaluator.infrastructure

import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.domains.expression_evaluator.infrastructure.ExpressionEvaluatorSpecifications.isDivisorZero
import org.example.calculatorapp.domains.expression_evaluator.infrastructure.ExpressionEvaluatorSpecifications.isThereMoreArithmeticToBeDone
import org.example.calculatorapp.domains.expression_evaluator.infrastructure.ExpressionEvaluatorSpecifications.isTokenAnOperator
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ExpressionEvaluatorSpecificationsTest {
    @Test
    fun testIfMethodIsTokenAnOperatorReturnsTrueIfTokenIsAnOperator() {
        val tokenIsAnOperator = isTokenAnOperator(ExpressionTokens.ADDITION.value)
        val tokenIsNotAnOperator = isTokenAnOperator(ExpressionTokens.ONE.value)

        assertTrue(tokenIsAnOperator)
        assertFalse(tokenIsNotAnOperator)
    }

    @Test
    fun testIfMethodIsThereMoreArithmeticToBeDoneReturnsTrueIfThereIsMoreArithmeticToBeDone() {
        val thereIsMoreArithmeticToBeDone = isThereMoreArithmeticToBeDone(
            mutableListOf(
                ExpressionTokens.ONE.value.toDouble(),
                ExpressionTokens.ONE.value.toDouble()
            ),
            mutableListOf(ExpressionTokens.ADDITION.value)
        )
        val thereIsNotMoreArithmeticToBeDone =
            isThereMoreArithmeticToBeDone(
                mutableListOf(
                    ExpressionTokens.ONE.value.toDouble(),
                ),
                mutableListOf()
            )

        assertTrue(thereIsMoreArithmeticToBeDone)
        assertFalse(thereIsNotMoreArithmeticToBeDone)
    }

    @Test
    fun testIfMethodIsDivisorZeroReturnsTrueIfDivisorIsEqualToZero() {
        val divisorIsEqualToZero = isDivisorZero(ExpressionTokens.ZERO.value.toDouble())
        val divisorIsNotEqualToZero = isDivisorZero(ExpressionTokens.ONE.value.toDouble())

        assertTrue(divisorIsEqualToZero)
        assertFalse(divisorIsNotEqualToZero)
    }
}