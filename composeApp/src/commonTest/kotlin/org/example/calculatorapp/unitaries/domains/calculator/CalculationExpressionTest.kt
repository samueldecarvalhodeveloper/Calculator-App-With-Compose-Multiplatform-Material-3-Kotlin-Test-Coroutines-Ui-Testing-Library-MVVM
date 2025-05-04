package org.example.calculatorapp.unitaries.domains.calculator

import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.domains.calculator.CalculationExpression
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculationExpressionTest {
    @Test
    fun testIfClassRepresentsHowCalculationExpressionShouldBeUsedOnClient() {
        val calculationExpression = CalculationExpression("")

        val currentCalculationExpression = calculationExpression.calculationExpression

        assertEquals("", currentCalculationExpression)

        calculationExpression.calculationExpression = SIMPLE_CALCULATION_EXPRESSION

        val updateCalculationExpression = calculationExpression.calculationExpression

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, updateCalculationExpression)
    }
}