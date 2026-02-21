package com.rakapermanaptr.presentation.home

import com.rakapermanaptr.base.UiEffect
import com.rakapermanaptr.base.UiEvent
import com.rakapermanaptr.base.UiState
import com.rakapermanaptr.domain.home.entity.Journal

sealed class HomeViewEvent : UiEvent {
    data object Initial: HomeViewEvent()
}

data class HomeViewState(
    val isLoading: Boolean = false,
    val journals: List<Journal> = emptyList()
): UiState

sealed class HomeViewEffect : UiEffect {

}