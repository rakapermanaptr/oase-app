package com.rakapermanaptr.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.domain.OaseRepository
import com.rakapermanaptr.domain.home.entity.Journal
import kotlinx.coroutines.launch

class TestViewModel(private val repository: OaseRepository) : ViewModel() {

    // Internal mutable state
    private val _uiState = mutableStateOf<List<Journal>>(emptyList())
    // Exposed read-only state
    val uiState = _uiState

    fun loadJournals() {
        viewModelScope.launch {
            try {
                _uiState.value = repository.getJournals()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    suspend fun getJournals() = repository.getJournals()
}