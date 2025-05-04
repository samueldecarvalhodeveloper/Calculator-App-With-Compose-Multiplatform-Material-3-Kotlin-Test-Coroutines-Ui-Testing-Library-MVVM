package org.example.calculatorapp.unitaries.infrastructure.factories

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION
import org.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import org.example.calculatorapp.infrastructure.factories.CalculatorViewModelFactory
import kotlin.test.Test
import kotlin.test.assertNotNull

@OptIn(ExperimentalSettingsApi::class)
class CalculatorViewModelFactoryTest {
    @Test
    fun testIfMethodGetInstanceReturnsAnWorkingInstance() {
        runBlocking {
            val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

            keyValueDatabaseImplementation.putString(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                SIMPLE_CALCULATION_EXPRESSION
            )

            val instance = CalculatorViewModelFactory.getInstance(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                keyValueDatabaseImplementation
            )

            assertNotNull(instance)
        }
    }
}
