package org.example.calculatorapp.calculation_expression_store

import org.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import org.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class CalculationExpressionStore(private val keyValueDatabase: KeyValueDatabase) {
    suspend fun getStoredCalculationExpression(): String {
        return try {
            keyValueDatabase.getStringValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY)
        } catch (_: NotExistingKeyException) {
            ""
        }
    }

    suspend fun setStoredCalculationExpression(newCalculationExpression: String) {
        keyValueDatabase.setStringValue(
            LAST_SESSION_CALCULATION_EXPRESSION_KEY, newCalculationExpression
        )
    }
}