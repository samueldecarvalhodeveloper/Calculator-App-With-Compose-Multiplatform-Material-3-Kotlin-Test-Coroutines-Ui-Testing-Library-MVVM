package org.example.calculatorapp.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore

class ThemeModeViewModel(
    initialThemeMode: Boolean, private val userInterfaceThemeStore: UserInterfaceThemeStore
) : ViewModel() {
    private val _themeMode = mutableStateOf(initialThemeMode)
    val themeMode: State<Boolean> = _themeMode

    fun toggleTheme() {
        viewModelScope.launch {
            _themeMode.value = !themeMode.value

            userInterfaceThemeStore.setNightModeThemeState(themeMode.value)
        }
    }
}