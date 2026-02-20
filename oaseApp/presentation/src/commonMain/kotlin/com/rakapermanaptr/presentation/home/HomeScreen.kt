package com.rakapermanaptr.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {

    val journals by viewModel.uiState
    println("TEST_JOURNALS: $journals")

    LaunchedEffect(Unit) {
        viewModel.loadJournals()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(journals) { journal ->
                Text(text = journal.journal)
            }
        }
    }
}