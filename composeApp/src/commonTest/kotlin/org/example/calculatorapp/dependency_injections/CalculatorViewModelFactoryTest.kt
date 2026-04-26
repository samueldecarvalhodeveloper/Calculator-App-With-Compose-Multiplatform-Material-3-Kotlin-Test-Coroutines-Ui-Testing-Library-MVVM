package org.example.calculatorapp.dependency_injections

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.runBlocking
import org.example.calculatorapp.constants.domains.CalculatorConstants.EXPRESSION_TO_BE_EVALUATED
import org.example.calculatorapp.constants.domains.ExpressionEvaluatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import org.example.calculatorapp.constants.UserInterfaceConstants.EXPRESSION_KEY
import kotlin.test.Test
import kotlin.test.assertNotNull

@OptIn(ExperimentalSettingsApi::class)
class CalculatorViewModelFactoryTest {
    @Test
    fun testIfMethodGetInstanceReturnsAnWorkingInstance() {
        runBlocking {
            val keyValueDatabaseImplementation = MapSettings().toSuspendSettings()

            keyValueDatabaseImplementation.putString(
                EXPRESSION_KEY,
                EXPRESSION_TO_BE_EVALUATED
            )

            val instance = CalculatorViewModelFactory.getInstance(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                keyValueDatabaseImplementation
            )

            assertNotNull(instance)
        }
    }
}
