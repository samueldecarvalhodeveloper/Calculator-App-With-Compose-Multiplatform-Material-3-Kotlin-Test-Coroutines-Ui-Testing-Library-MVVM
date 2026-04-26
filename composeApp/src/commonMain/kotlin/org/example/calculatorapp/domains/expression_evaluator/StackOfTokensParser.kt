package org.example.calculatorapp.domains.expression_evaluator

object StackOfTokensParser {
    fun parseStacks(
        stackOfOperands: MutableList<Double>,
        stackOfOperators: MutableList<String>,
        bagOfTokens: List<String>
    ) {
        for (token in bagOfTokens) {
            EquationParser.parseEquation(stackOfOperands, stackOfOperators, token)
        }
    }
}