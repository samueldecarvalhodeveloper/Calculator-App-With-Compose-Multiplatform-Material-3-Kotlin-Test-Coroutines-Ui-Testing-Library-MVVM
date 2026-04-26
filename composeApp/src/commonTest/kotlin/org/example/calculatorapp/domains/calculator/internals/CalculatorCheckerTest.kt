package org.example.calculatorapp.domains.calculator.internals

import org.example.calculatorapp.constants.domains.CalculatorConstants.NUMBER_WITHOUT_REST
import org.example.calculatorapp.constants.domains.CalculatorConstants.NUMBER_WITH_REST
import org.example.calculatorapp.domains.calculator.internals.CalculatorChecker.isCalculationExpressionRationalNumber
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CalculatorCheckerTest {
    @Test
    fun testIfMethodIsCalculationExpressionARationalNumberReturnsTrueIfNumberIsAFloatingNumber() {
        val rationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITH_REST)
        val notRationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITHOUT_REST)

        assertTrue(rationalNumber)
        assertFalse(notRationalNumber)
    }
}