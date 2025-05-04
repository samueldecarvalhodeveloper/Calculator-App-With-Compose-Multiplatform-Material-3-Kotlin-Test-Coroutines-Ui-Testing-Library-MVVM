package org.example.calculatorapp.unitaries.calculation_expression_store

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import org.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSettingsApi::class)
class CalculationExpressionStoreTest {
    private lateinit var keyValueDatabase: KeyValueDatabase
    private lateinit var calculationExpressionStore: CalculationExpressionStore

    @BeforeTest
    fun beforeEach() {
        var keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

        keyValueDatabase = KeyValueDatabase(keyValueDatabaseImplementation)

        calculationExpressionStore = CalculationExpressionStore(keyValueDatabase)
    }

    @Test
    fun testIfMethodGetStoredCalculationExpressionReturnsStoredCalculationExpressionStoredFromKeyValueDatabase() {
        runBlocking {
            keyValueDatabase.setStringValue(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                SIMPLE_CALCULATION_EXPRESSION
            )

            var storedCalculationExpression =
                calculationExpressionStore.getStoredCalculationExpression()

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression)
        }
    }

    @Test
    fun testIfMethodSetStoredCalculationExpressionUpdatesStoredCalculationExpressionOnKeyValueDatabase() {
        runBlocking {
            calculationExpressionStore.setStoredCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

            var storedCalculationExpression =
                keyValueDatabase.getStringValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY)

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression)
        }
    }
}