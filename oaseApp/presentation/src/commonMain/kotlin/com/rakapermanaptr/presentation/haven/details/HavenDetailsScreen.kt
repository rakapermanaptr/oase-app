package com.rakapermanaptr.presentation.haven.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rakapermanaptr.design_system.OaseTextField
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HavenDetailsScreen(roomId: String, viewModel: HavenDetailsViewModel = koinViewModel()) {
    Text(text = "roomId: $roomId")

    LaunchedEffect(Unit) {
        viewModel.onEvent(HavenViewEvent.Initial(roomId))
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OaseTextField(
                    value = "",
                    onValueChange = {

                    },
                    label = "",
                    modifier = Modifier.weight(0.7F)
                )

                Button(
                    onClick = {

                    },
                    modifier = Modifier.weight(0.3F)
                ) {
                    Text(
                        text = "Send"
                    )
                }
            }
        }
    ) { innerPadding ->

    }

}

@Composable
fun ChatBubble(message: MessageModel, isMine: Boolean) {
    val alignment = if (isMine) Alignment.CenterEnd else Alignment.CenterStart
    val color = if (isMine) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer
    val shape = if (isMine)
        RoundedCornerShape(16.dp, 16.dp, 0.dp, 16.dp) else
        RoundedCornerShape(16.dp, 16.dp, 16.dp, 0.dp)

    Box(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Surface(
            modifier = Modifier.align(alignment).widthIn(max = 280.dp),
            color = color,
            shape = shape
        ) {
            Text(
                text = message.content,
                modifier = Modifier.padding(12.dp),
                color = if (isMine) Color.White else Color.Black
            )
        }
    }
}

data class MessageModel(
    val content: String
)