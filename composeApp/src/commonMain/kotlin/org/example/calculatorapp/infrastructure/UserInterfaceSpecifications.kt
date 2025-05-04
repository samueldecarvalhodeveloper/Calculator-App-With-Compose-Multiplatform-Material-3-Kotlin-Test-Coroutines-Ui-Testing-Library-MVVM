package org.example.calculatorapp.infrastructure

import androidx.compose.ui.unit.Dp
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import org.example.calculatorapp.constants.UserInterfaceConstants.SMALL_SCREEN_HEIGHT

@OptIn(ExperimentalSettingsApi::class)
object UserInterfaceSpecifications {
    fun isScreenHeightSmall(currentScreenHeight: Dp): Boolean {
        return currentScreenHeight < SMALL_SCREEN_HEIGHT
    }

    suspend fun isOnKeyValueDatabase(
        key: String, keyValueDatabaseImplementation: SuspendSettings
    ): Boolean {
        return keyValueDatabaseImplementation.hasKey(key)
    }
}