package org.example.calculatorapp.user_interface.data_stores

import org.example.calculatorapp.constants.UserInterfaceConstants
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase

class ExpressionDataStore(private val keyValueDatabase: KeyValueDatabase) {
    suspend fun getStoredExpression(): String {
        return try {
            keyValueDatabase.getStringValue(UserInterfaceConstants.EXPRESSION_KEY)
        } catch (_: Exception) {
            ""
        }
    }

    suspend fun setStoredExpression(newCalculationExpression: String) {
        keyValueDatabase.setStringValue(
            UserInterfaceConstants.EXPRESSION_KEY, newCalculationExpression
        )
    }
}