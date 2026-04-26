package org.example.calculatorapp.user_interface.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.calculatorapp.user_interface.data_stores.ThemeDataStore

class ThemeModeViewModel(
    initialThemeMode: Boolean,
    private val themeDataStore: ThemeDataStore,
    private var suspendedFunctionContext: ((suspend () -> Unit) -> Unit)? = null
) : ViewModel() {
    private val _themeMode = mutableStateOf(initialThemeMode)
    val themeMode: State<Boolean> = _themeMode

    init {
        if(suspendedFunctionContext == null) {
            suspendedFunctionContext = {
                viewModelScope.launch {
                    it()
                }
            }
        }
    }

    fun toggleTheme() {
        _themeMode.value = !themeMode.value

        suspendedFunctionContext?.invoke {
            themeDataStore.setNightModeThemeState(themeMode.value)
        }
    }
}