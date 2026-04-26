package org.example.calculatorapp.constants.infrastructure

object KeyValueDatabaseConstants {
    fun NOT_EXISTING_KEY_EXCEPTION_MESSAGE(key: String): String {
        return "Key: \"$key\"; Does Not Exist!"
    }
}