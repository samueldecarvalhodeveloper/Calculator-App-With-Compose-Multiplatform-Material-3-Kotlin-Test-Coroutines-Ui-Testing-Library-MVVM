package org.example.calculatorapp.domains.expression_evaluator

object ExpressionEvaluator {
    fun getEvaluatedExpression(expression: String): Double {
        val stackOfOperators = mutableListOf<String>()
        val stackOfOperands = mutableListOf<Double>()

        val bagOfTokens = ExpressionTokenizer.getTokensFromExpression(expression)

        StackOfTokensParser.parseStacks(stackOfOperands, stackOfOperators, bagOfTokens)

        ExpressionEvaluatorValidator.validateIfEvaluationOfAllTokensEnded(stackOfOperators)

        return stackOfOperands.last()
    }
}