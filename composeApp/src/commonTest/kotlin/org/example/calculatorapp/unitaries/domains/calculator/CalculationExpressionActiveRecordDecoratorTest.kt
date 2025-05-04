package org.example.calculatorapp.unitaries.domains.calculator

import org.example.calculatorapp.constants.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.domains.calculator.CalculationExpression
import org.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import org.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculationExpressionActiveRecordDecoratorTest {
    private lateinit var calculationExpressionActiveRecordDecorator: CalculationExpressionActiveRecordDecorator
    private lateinit var calculationExpressionRegister: CalculationExpressionRegister

    @BeforeTest
    fun beforeEach() {
        val calculationExpression = CalculationExpression("")
        calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
        calculationExpressionActiveRecordDecorator =
            CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)

        calculationExpressionRegister.setCalculationExpression("")
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        val currentCalculationExpression =
            calculationExpressionActiveRecordDecorator.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterToCalculationExpressionTurnsCalculationToEmptyWhenIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpressionActiveRecordDecorator.addCharacterToCalculationExpression(
            ExpressionTokens.ONE
        )

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)

        calculationExpressionActiveRecordDecorator.addCharacterToCalculationExpression(
            ExpressionTokens.ONE
        )

        val updateCalculationExpression = calculationExpressionRegister.getCalculationExpression()

        assertEquals(ExpressionTokens.ONE.value, updateCalculationExpression)
    }

    @Test
    fun testIfMethodRemoveLastCharacterFromCalculationExpressionTurnsCalculationEmptyIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpressionActiveRecordDecorator.removeLastCharacterFromCalculationExpression()

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodTurnCalculationExpressionEmptyCallsTheSuperTypeMethodAndTurnsExpressionEmpty() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecordDecorator.turnCalculationExpressionEmpty()

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodEvaluateCalculationExpressionDoNotDoNothingIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpressionActiveRecordDecorator.evaluateCalculationExpression()

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, currentCalculationExpression)

        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecordDecorator.evaluateCalculationExpression()

        val syntaxCorrectCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, syntaxCorrectCalculationExpression)
    }

}