package org.example.calculatorapp.infrastructure.exceptions

import org.example.calculatorapp.constants.UserInterfaceConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE

class NotExistingKeyException(key: String) : Exception(
    NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
        key
    )
)