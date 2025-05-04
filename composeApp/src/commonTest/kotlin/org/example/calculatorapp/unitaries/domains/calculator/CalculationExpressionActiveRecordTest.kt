package org.example.calculatorapp.unitaries.domains.calculator

import org.example.calculatorapp.constants.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER
import org.example.calculatorapp.domains.calculator.CalculationExpression
import org.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecord
import org.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculationExpressionActiveRecordTest {
    private lateinit var calculationExpressionActiveRecord: CalculationExpressionActiveRecord
    private lateinit var calculationExpressionRegister: CalculationExpressionRegister

    @BeforeTest
    fun beforeEach() {
        val calculationExpression = CalculationExpression("")
        calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
        calculationExpressionActiveRecord =
            CalculationExpressionActiveRecord(calculationExpressionRegister)
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        val currentCalculationExpression =
            calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterToCalculatorExpressionAddChoseCharacterToCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(ExpressionTokens.ONE)

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(ExpressionTokens.ONE.value, currentCalculationExpression)
    }

    @Test
    fun testIfMethodRemoveLastCharacterFromCalculationExpressionRemovesLastCharacterFromExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecord.removeLastCharacterFromCalculationExpression()

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(
            SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER,
            currentCalculationExpression
        )
    }

    @Test
    fun testIfMethodTurnCalculationExpressionEmptyMakesTheCalculationExpressionIntoEmptyString() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)

        calculationExpressionActiveRecord.turnCalculationExpressionEmpty()

        val updatedCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", updatedCalculationExpression)
    }

    @Test
    fun testIfMethodEvaluateCalculationExpressionTurnsTheCalculationExpressionIntoEvaluatedValue() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecord.evaluateCalculationExpression()

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)
    }
}