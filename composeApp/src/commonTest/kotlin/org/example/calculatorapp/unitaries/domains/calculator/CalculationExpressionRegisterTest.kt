package org.example.calculatorapp.unitaries.domains.calculator

import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.domains.calculator.CalculationExpression
import org.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculationExpressionRegisterTest {
    private lateinit var calculationExpression: CalculationExpression
    private lateinit var calculationExpressionRegister: CalculationExpressionRegister

    @BeforeTest
    fun beforeEach() {
        calculationExpression = CalculationExpression("")
        calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnsTheCurrentCalculationExpression() {
        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodSetCalculationExpressionReplacesTheCalculationExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        val currentCalculationExpression: String = calculationExpression.calculationExpression

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterToCalculationExpressionAddsChoseCharacterToCalculationExpression() {
        calculationExpressionRegister.addCharacterToCalculationExpression(ExpressionTokens.ONE)

        val currentCalculationExpression: String = calculationExpression.calculationExpression

        assertEquals(ExpressionTokens.ONE.value, currentCalculationExpression)
    }
}