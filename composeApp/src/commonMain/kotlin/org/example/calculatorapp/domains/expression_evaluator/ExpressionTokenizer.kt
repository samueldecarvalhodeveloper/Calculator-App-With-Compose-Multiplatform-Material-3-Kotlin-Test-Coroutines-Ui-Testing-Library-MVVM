package org.example.calculatorapp.domains.expression_evaluator

object ExpressionTokenizer {
    fun getTokensFromExpression(expression: String): List<String> {
        return expression.split("""(?<=[+\-\*])|(?=[+\-\*])""".toRegex())
    }
}