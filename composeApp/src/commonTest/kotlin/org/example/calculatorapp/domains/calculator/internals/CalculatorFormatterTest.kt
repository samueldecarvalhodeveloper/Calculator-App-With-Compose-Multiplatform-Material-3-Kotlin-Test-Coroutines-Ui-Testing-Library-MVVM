package org.example.calculatorapp.domains.calculator.internals

import org.example.calculatorapp.constants.domains.CalculatorConstants.FLOATING_POINT_NUMBER
import org.example.calculatorapp.constants.domains.CalculatorConstants.NON_FLOATING_POINT_NUMBER
import org.example.calculatorapp.constants.domains.CalculatorConstants.EXPRESSION_TO_BE_EVALUATED
import org.example.calculatorapp.constants.domains.CalculatorConstants.EXPRESSION_TO_BE_EVALUATED_WITHOUT_LAST_CHARACTER
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorFormatterTest {
    @Test
    fun testIfMethodGetExpressionWithoutLastCharacterReturnExpressionWithoutLastCharacter() {
        val calculationExpressionWithoutLastCharacter: String =
            CalculatorFormatter.getExpressionWithoutLastCharacter(EXPRESSION_TO_BE_EVALUATED)

        assertEquals(
            EXPRESSION_TO_BE_EVALUATED_WITHOUT_LAST_CHARACTER,
            calculationExpressionWithoutLastCharacter
        )
    }

    @Test
    fun testIfMethodGetFixedEvaluatedExpressionReturnsExpressionWithNoFloatingPointIfNumberIsAbleToBeAnInteger() {
        val calculationExpressionWithoutLastCharacter: String =
            CalculatorFormatter.getFixedEvaluatedExpression(FLOATING_POINT_NUMBER)

        assertEquals(
            NON_FLOATING_POINT_NUMBER,
            calculationExpressionWithoutLastCharacter
        )
    }
}