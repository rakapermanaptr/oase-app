package com.rakapermanaptr.presentation.haven

import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.base.BaseViewModel
import com.rakapermanaptr.base.utils.AppLogger
import com.rakapermanaptr.domain.haven.usecase.CreateHavenUseCase
import com.rakapermanaptr.domain.haven.usecase.GetHavenListUseCase
import kotlinx.coroutines.launch

class HavenViewModel(
    private val createHavenUseCase: CreateHavenUseCase,
    private val getHavenListUseCase: GetHavenListUseCase,
) : BaseViewModel<HavenViewEvent, HavenViewState, HavenViewEffect>(
    initialState = HavenViewState()
) {

    override suspend fun handleEvent(event: HavenViewEvent) {
        when (event) {
            HavenViewEvent.Initial -> fetchHavenList()
            is HavenViewEvent.OnCreateHaven -> createHaven(userId = event.userId)
        }
    }

    private fun fetchHavenList() {
        viewModelScope.launch {
            getHavenListUseCase()
                .onSuccess {
                    AppLogger.d("HavenViewModel", "onSuccess: $it")
                    setState { copy(havenList = it) }
                }.onFailure {
                    AppLogger.d("HavenViewModel", "onFailure: $it")
                }
        }
    }

    private fun createHaven(userId: String) {
        viewModelScope.launch {
            createHavenUseCase(userId)
                .onSuccess {
                    AppLogger.d("HavenViewModel", "onSuccess")
                }.onFailure {
                    AppLogger.d("HavenViewModel", "onFailure: $it")
                }
        }
    }
}