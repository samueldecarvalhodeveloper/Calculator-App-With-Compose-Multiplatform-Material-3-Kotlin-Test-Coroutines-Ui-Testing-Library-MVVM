package org.example.calculatorapp.unitaries.infrastructure.exceptions

import org.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import org.example.calculatorapp.constants.UserInterfaceConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE
import org.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException
import kotlin.test.Test
import kotlin.test.assertEquals

class NotExistingKeyExceptionTest {
    @Test
    fun testIfClassDeclaresHowNotExistingKeyExceptionShouldBeThrown() {
        try {
            throw NotExistingKeyException(LAST_SESSION_CALCULATION_EXPRESSION_KEY)
        } catch (exception: Exception) {
            val exceptionMessage = exception.message

            assertEquals(
                NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
                    LAST_SESSION_CALCULATION_EXPRESSION_KEY
                ),
                exceptionMessage
            )
        }
    }
}