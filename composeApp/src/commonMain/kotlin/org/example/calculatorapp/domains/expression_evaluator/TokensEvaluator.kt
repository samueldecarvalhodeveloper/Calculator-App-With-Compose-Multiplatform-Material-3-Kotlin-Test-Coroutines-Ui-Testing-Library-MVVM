package org.example.calculatorapp.domains.expression_evaluator

import org.example.calculatorapp.domains.expression_evaluator.infrastructure.ExpressionEvaluatorSpecifications.isThereMoreArithmeticToBeDone

object TokensEvaluator {
    fun evaluateTokens(
        stackOfOperands: MutableList<Double>,
        stackOfOperators: MutableList<String>
    ) {
        if (isThereMoreArithmeticToBeDone(stackOfOperands, stackOfOperators)) {
            val operator = stackOfOperators.removeLast()

            val secondOperand = stackOfOperands.removeLast()
            val firstOperand = stackOfOperands.removeLast()

            val resultOfParsedExpressionArithmetic =
                ArithmeticParser.parseExpressionArithmetic(firstOperand, operator, secondOperand)

            stackOfOperands.add(resultOfParsedExpressionArithmetic)
        }
    }
}
