package com.rakapermanaptr.presentation.haven.details

import com.rakapermanaptr.base.UiEffect
import com.rakapermanaptr.base.UiEvent
import com.rakapermanaptr.base.UiState

sealed class HavenViewEvent : UiEvent {
    data class Initial(val roomId: String): HavenViewEvent()
}

data class HavenViewState(
    val isLoading: Boolean = false
): UiState

sealed class HavenViewEffect : UiEffect {

}