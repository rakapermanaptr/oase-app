package com.rakapermanaptr.presentation.haven

import com.rakapermanaptr.base.UiEffect
import com.rakapermanaptr.base.UiEvent
import com.rakapermanaptr.base.UiState
import com.rakapermanaptr.domain.haven.entity.Haven

sealed class HavenViewEvent : UiEvent {
    data class OnCreateHaven(val userId: String) : HavenViewEvent()
    data object Initial: HavenViewEvent()
}

data class HavenViewState(
    val isLoading: Boolean = false,
    val havenList: List<Haven> = emptyList()
): UiState

sealed class HavenViewEffect : UiEffect {
    
}