package org.example.calculatorapp.infrastructure.exceptions

import org.example.calculatorapp.constants.infrastructure.KeyValueDatabaseConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE

class NotExistingKeyException(key: String) : Exception(
    NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
        key
    )
)