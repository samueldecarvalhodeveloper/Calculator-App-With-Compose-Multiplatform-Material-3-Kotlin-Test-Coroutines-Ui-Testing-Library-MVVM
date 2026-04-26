package org.example.calculatorapp.infrastructure.exceptions

import org.example.calculatorapp.constants.infrastructure.KeyValueDatabaseConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE
import org.example.calculatorapp.constants.UserInterfaceConstants.EXPRESSION_KEY
import kotlin.test.Test
import kotlin.test.assertEquals

class NotExistingKeyExceptionTest {
    @Test
    fun testIfClassDeclaresHowNotExistingKeyExceptionShouldBeThrown() {
        try {
            throw NotExistingKeyException(EXPRESSION_KEY)
        } catch (exception: Exception) {
            val exceptionMessage = exception.message

            assertEquals(
                NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
                    EXPRESSION_KEY
                ),
                exceptionMessage
            )
        }
    }
}