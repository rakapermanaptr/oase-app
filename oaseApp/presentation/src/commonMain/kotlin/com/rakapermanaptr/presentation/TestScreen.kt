package com.rakapermanaptr.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TestScreen(viewModel: TestViewModel = koinViewModel()) {
    // Collect the state from the ViewModel
    val journals by viewModel.uiState
    println("TEST_JOURNALS: $journals")

    LaunchedEffect(Unit) {
        viewModel.loadJournals()
    }

    LazyColumn {
        items(journals) { journal ->
            Text(text = journal.journal)
        }
    }
}