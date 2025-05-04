package org.example.calculatorapp.unitaries.domains.calculator.infrastructure

import org.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.constants.CalculatorConstants.NUMBER_WITHOUT_REST
import org.example.calculatorapp.constants.CalculatorConstants.NUMBER_WITH_REST
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionEmpty
import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage
import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorSpecifications.isCalculationExpressionRationalNumber
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CalculatorSpecificationsTest {
    @Test
    fun testIfMethodIsCalculationExpressionARationalNumberReturnsTrueIfNumberIsAFloatingNumber() {
        val rationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITH_REST)
        val notRationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITHOUT_REST)

        assertTrue(rationalNumber)
        assertFalse(notRationalNumber)
    }

    @Test
    fun testIfMethodIsCalculationExpressionEmptyReturnsTrueIfCalculationExpressionIsEmpty() {
        val emptyExpression: Boolean = isCalculationExpressionEmpty("")
        val notEmptyExpression: Boolean =
            isCalculationExpressionEmpty(SIMPLE_CALCULATION_EXPRESSION)

        assertTrue(emptyExpression)
        assertFalse(notEmptyExpression)
    }

    @Test
    fun testIfMethodIsCalculationExpressionNotValidExpressionExceptionMessageReturnsTrueIfCalculationExpressionIsNotValidExpressionMessage() {
        val calculationExpressionIsNotValidExpressionMessage: Boolean =
            isCalculationExpressionNotValidExpressionExceptionMessage(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
            )
        val notValidExpressionMessage: Boolean =
            isCalculationExpressionNotValidExpressionExceptionMessage(SIMPLE_CALCULATION_EXPRESSION)

        assertTrue(calculationExpressionIsNotValidExpressionMessage)
        assertFalse(notValidExpressionMessage)
    }
}