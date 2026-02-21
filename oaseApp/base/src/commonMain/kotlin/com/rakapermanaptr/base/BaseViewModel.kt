package com.rakapermanaptr.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.base.utils.AppLogger
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<EVENT, STATE, EFFECT>(
    initialState: STATE
) : ViewModel() {


    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<STATE> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<EFFECT>()
    val effect = _effect.asSharedFlow()

    protected val currentState get() = _state.value

    fun onEvent(event: EVENT) {
        AppLogger.d(tag = TAG, message = "onEvent: $event")
        viewModelScope.launch { handleEvent(event) }
    }

    protected abstract suspend fun handleEvent(event: EVENT)

    protected fun setState(reducer: STATE.() -> STATE) {
        _state.update { it.reducer() }
    }

    protected fun setEffect(builder: () -> EFFECT) {
        AppLogger.d(tag = TAG, message = "$builder")
        viewModelScope.launch { _effect.emit(builder()) }
    }

    companion object {
        val TAG = this::class.simpleName ?: "BaseViewModel"
    }
}