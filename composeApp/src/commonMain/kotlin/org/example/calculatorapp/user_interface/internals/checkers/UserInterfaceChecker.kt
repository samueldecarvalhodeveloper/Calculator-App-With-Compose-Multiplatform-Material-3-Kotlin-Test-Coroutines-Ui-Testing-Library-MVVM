package org.example.calculatorapp.user_interface.internals.checkers

import androidx.compose.ui.unit.Dp
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import org.example.calculatorapp.constants.UserInterfaceConstants

@OptIn(ExperimentalSettingsApi::class)
object UserInterfaceChecker {
    fun isScreenHeightSmall(currentScreenHeight: Dp): Boolean {
        return currentScreenHeight < UserInterfaceConstants.SMALL_SCREEN_HEIGHT
    }

    suspend fun isOnKeyValueDatabase(
        key: String, keyValueDatabaseImplementation: SuspendSettings
    ): Boolean {
        return keyValueDatabaseImplementation.hasKey(key)
    }
}