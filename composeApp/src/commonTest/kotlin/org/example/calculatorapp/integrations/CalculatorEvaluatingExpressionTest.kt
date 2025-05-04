package org.example.calculatorapp.integrations

import org.example.calculatorapp.domains.calculator.CalculationExpression
import org.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import org.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import org.example.calculatorapp.domains.calculator.Calculator
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorEvaluatingExpressionTest {
    private lateinit var calculator: Calculator
    private lateinit var calculationExpressionActiveRecord: CalculationExpressionActiveRecordDecorator

    @BeforeTest
    fun beforeEach() {
        val calculationExpression = CalculationExpression("")
        val calculationExpressionRegister =
            CalculationExpressionRegister(calculationExpression)
        calculationExpressionActiveRecord =
            CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
        calculator = Calculator(calculationExpressionActiveRecord)
    }

    @Test
    fun testIfExpressionIfBeingEvaluatedOnCalculator() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(ExpressionTokens.ONE)
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(ExpressionTokens.ADDITION)
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(ExpressionTokens.ONE)

        calculator.evaluate()

        val currentCalculationExpression: String =
            calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals(ExpressionTokens.TWO.value, currentCalculationExpression)
    }
}