package org.example.calculatorapp.unitaries.domains.calculator.infrastructure

import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER
import org.example.calculatorapp.domains.calculator.infrastructure.CalculatorFormatter.getCalculationExpressionWithoutLastCharacter
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorFormatterTest {
    @Test
    fun testIfMethodGetCalculationExpressionWithoutLastCharacterReturnExpressionWithoutLastCharacter() {
        val calculationExpressionWithoutLastCharacter: String =
            getCalculationExpressionWithoutLastCharacter(SIMPLE_CALCULATION_EXPRESSION)

        assertEquals(
            SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER,
            calculationExpressionWithoutLastCharacter
        )
    }
}