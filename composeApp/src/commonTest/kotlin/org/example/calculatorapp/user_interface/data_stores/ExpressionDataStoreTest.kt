package org.example.calculatorapp.user_interface.data_stores

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.test.runTest
import org.example.calculatorapp.constants.domains.CalculatorConstants
import org.example.calculatorapp.constants.UserInterfaceConstants
import org.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSettingsApi::class)
class ExpressionDataStoreTest {
    private lateinit var keyValueDatabase: KeyValueDatabase
    private lateinit var expressionDataStore: ExpressionDataStore

    @BeforeTest
    fun beforeEach() {
        val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

        keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)

        expressionDataStore = ExpressionDataStore(keyValueDatabase)
    }

    @Test
    fun testIfMethodGetStoredExpressionReturnsStoredExpressionStoredFromKeyValueDatabase() {
        runTest {
            keyValueDatabase.setStringValue(
                UserInterfaceConstants.EXPRESSION_KEY,
                CalculatorConstants.EXPRESSION_TO_BE_EVALUATED
            )

            val storedExpression =
                expressionDataStore.getStoredExpression()

            assertEquals(
                CalculatorConstants.EXPRESSION_TO_BE_EVALUATED,
                storedExpression
            )
        }
    }

    @Test
    fun testIfMethodSetStoredExpressionUpdatesStoredExpressionOnKeyValueDatabase() {
        runTest {
            expressionDataStore.setStoredExpression(CalculatorConstants.EXPRESSION_TO_BE_EVALUATED)

            val storedExpression =
                keyValueDatabase.getStringValue(UserInterfaceConstants.EXPRESSION_KEY)

            assertEquals(
                CalculatorConstants.EXPRESSION_TO_BE_EVALUATED,
                storedExpression
            )
        }
    }
}