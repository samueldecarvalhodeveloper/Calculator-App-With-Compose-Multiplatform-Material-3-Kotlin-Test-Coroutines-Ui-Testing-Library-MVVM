package org.example.calculatorapp.domains.calculator

import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.domains.expression_evaluator.NotValidExpressionException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeTest
    fun beforeEach() {
        calculator = Calculator("")
    }

    @Test
    fun testIfMethodAddCharacterAddsCharacterToExpression() {
        calculator.addCharacter(ExpressionTokens.ONE)

        assertEquals(ExpressionTokens.ONE.value, calculator.expression)
    }

    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromExpression() {
        calculator = Calculator(ExpressionTokens.ONE.value + ExpressionTokens.ONE.value)

        calculator.backspace()

        assertEquals(ExpressionTokens.ONE.value, calculator.expression)
    }

    @Test
    fun testIfMethodCleanRemovesAllCharactersFromExpression() {
        calculator = Calculator(ExpressionTokens.ONE.value + ExpressionTokens.ONE.value)

        calculator.clean()

        assertEquals("", calculator.expression)
    }

    @Test
    fun testIfMethodEvaluateEvaluatesExpression() {
        calculator = Calculator(
            ExpressionTokens.ONE.value +
                    ExpressionTokens.ADDITION.value +
                    ExpressionTokens.ONE.value
        )

        calculator.evaluate()

        assertEquals(ExpressionTokens.TWO.value, calculator.expression)
    }

    @Test
    fun testIfMethodEvaluateTurnsExpressionToEmptyAndRethrowsRisenException() {
        calculator = Calculator(ExpressionTokens.ADDITION.value + ExpressionTokens.ADDITION.value)

        try {
            calculator.evaluate()
        } catch (error: Exception) {
            assertEquals("", calculator.expression)

            assertIs<NotValidExpressionException>(error)
        }
    }
}