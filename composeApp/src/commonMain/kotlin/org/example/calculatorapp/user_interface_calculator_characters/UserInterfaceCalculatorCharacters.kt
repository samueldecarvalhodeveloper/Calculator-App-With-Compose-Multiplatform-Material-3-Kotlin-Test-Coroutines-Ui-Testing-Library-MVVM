package org.example.calculatorapp.user_interface_calculator_characters

import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens

enum class UserInterfaceCalculatorCharacters(val value: String) {
    ZERO(ExpressionTokens.ZERO.value),

    ONE(ExpressionTokens.ONE.value),

    TWO(ExpressionTokens.TWO.value),

    THREE(ExpressionTokens.THREE.value),

    FOUR(ExpressionTokens.FOUR.value),

    FIVE(ExpressionTokens.FIVE.value),

    SIX(ExpressionTokens.SIX.value),

    SEVEN(ExpressionTokens.SEVEN.value),

    EIGHT(ExpressionTokens.EIGHT.value),

    NINE(ExpressionTokens.NINE.value),

    ADDITION(ExpressionTokens.ADDITION.value),

    SUBTRACTION(ExpressionTokens.SUBTRACTION.value),

    DIVISION(ExpressionTokens.DIVISION.value),

    MULTIPLICATION(ExpressionTokens.MULTIPLICATION.value),

    POINT(ExpressionTokens.POINT.value),

    CLEAN("C"),

    EVALUATION("="),

    BACKSPACE("<")
}