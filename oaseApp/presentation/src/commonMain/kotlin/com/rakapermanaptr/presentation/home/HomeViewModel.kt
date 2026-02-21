package com.rakapermanaptr.presentation.home

import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.base.BaseViewModel
import com.rakapermanaptr.domain.home.usecase.GetJournalsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getJournalsUseCase: GetJournalsUseCase
) : BaseViewModel<HomeViewEvent, HomeViewState, HomeViewEffect>(
    initialState = HomeViewState()
) {

    override suspend fun handleEvent(event: HomeViewEvent) {
        when (event) {
            HomeViewEvent.Initial -> fetchJournals()
        }
    }

    private fun fetchJournals() {
        setState { copy(isLoading = true) }
        viewModelScope.launch {
            runCatching { getJournalsUseCase() }
                .onSuccess {
                    setState { copy(isLoading = false, journals = it) }
                }
                .onFailure {
                    setState { copy(isLoading = false) }
                }
        }
    }
}
