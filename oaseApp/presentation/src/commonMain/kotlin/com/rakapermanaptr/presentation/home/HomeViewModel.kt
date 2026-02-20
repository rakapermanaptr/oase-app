package com.rakapermanaptr.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.domain.home.entity.Journal
import com.rakapermanaptr.domain.home.usecase.GetJournalsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getJournalsUseCase: GetJournalsUseCase) : ViewModel() {
    // Internal mutable state
    private val _uiState = mutableStateOf<List<Journal>>(emptyList())
    // Exposed read-only state
    val uiState = _uiState

    fun loadJournals() {
        viewModelScope.launch {
            try {
                _uiState.value = getJournalsUseCase()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
