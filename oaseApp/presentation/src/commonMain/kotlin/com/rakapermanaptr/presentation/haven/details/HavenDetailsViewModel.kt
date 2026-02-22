package com.rakapermanaptr.presentation.haven.details

import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.base.BaseViewModel
import com.rakapermanaptr.domain.haven.detail.usecase.ObserveMessageUseCase
import kotlinx.coroutines.launch

class HavenDetailsViewModel(
    private val observeMessageUseCase: ObserveMessageUseCase
) : BaseViewModel<HavenViewEvent, HavenViewState, HavenViewEffect>(
    initialState = HavenViewState()
) {

    override suspend fun handleEvent(event: HavenViewEvent) {
        when (event) {
            is HavenViewEvent.Initial -> observeMessages(roomId = event.roomId)
        }
    }

    private fun observeMessages(roomId: String) {
        viewModelScope.launch {
            runCatching {
                observeMessageUseCase(roomId)
            }.onSuccess {
                val data = it
            }.onFailure {

            }
        }
    }

}