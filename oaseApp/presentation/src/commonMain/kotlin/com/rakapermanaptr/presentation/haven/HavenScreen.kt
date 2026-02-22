package com.rakapermanaptr.presentation.haven

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rakapermanaptr.domain.haven.entity.Haven
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HavenScreen(
    viewModel: HavenViewModel = koinViewModel(),
    onNavigateToHavenDetails: (roomId: String) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.onEvent(HavenViewEvent.Initial)
    }

    val state by viewModel.state.collectAsState()


    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state.havenList) { haven ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onNavigateToHavenDetails(haven.roomId)
                    }
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                        Text(text = haven.opponentName)
                        Text(text = haven.lastMessage)
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                viewModel.onEvent(HavenViewEvent.OnCreateHaven(userId = "b6db8bca-d447-4a90-bde5-b618b6364503"))
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text(text = "Create")
        }
    }

}

data object DummyData {
    fun generateDummyHaven(): List<Haven> {
        val dummy = arrayListOf<Haven>()
        repeat(20) {
            dummy.add(Haven(myId = "", roomId = "", "", "", ""))
        }

        return dummy
    }
}