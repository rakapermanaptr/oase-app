package com.rakapermanaptr.data.features.haven.details.repository

import com.rakapermanaptr.data.features.haven.details.model.MessageDto
import com.rakapermanaptr.domain.haven.detail.entity.Message
import com.rakapermanaptr.domain.haven.detail.repository.IChatRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.annotations.SupabaseExperimental
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.channel
import io.github.jan.supabase.realtime.decodeRecord
import io.github.jan.supabase.realtime.postgresChangeFlow
import io.github.jan.supabase.realtime.realtime
import io.github.jan.supabase.realtime.selectAsFlow
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class ChatRepository(private val supabase: SupabaseClient) : IChatRepository {

    override suspend fun observeMessages(roomId: String): Flow<List<Message>> = channelFlow {
        val channel = supabase.channel("messages")
        channel.postgresChangeFlow<PostgresAction.Insert>(schema = "public") {
            table = "messages"
        }.onEach {
            // Handle new message (it.record) and update UI
        }.launchIn(MainScope())
        channel.subscribe()

//        val cache = mutableListOf<Message>()
//
//        // --- initial load
//        val initial = supabase.from("messages")
//            .select {
//                filter { eq("room_id", roomId) }
//            }
//            .decodeList<MessageDto>()
//            .map { it.toDomain() }
//
//        cache.addAll(initial)
//        send(cache.toList())
//
//        // --- realtime
//        val channel = supabase.realtime.channel("messages-$roomId") {
//
//        }
//
//        launch {
//            channel.postgresChangeFlow<PostgresAction.Insert>(
//                schema = "public"
//            ) {
//                table = "messages"
//            }.collect { change ->
//
//                val newMsg = change.decodeRecord<MessageDto>().toDomain()
//
//                println("TEST_DEBUG realtime: $newMsg")
//
//                cache.add(newMsg)
//                send(cache.toList())
//            }
//        }
//
//        channel.subscribe()
//
//        awaitClose {
//            launch {
//                channel.unsubscribe()
//            }
//        }
    }

//    override suspend fun sendMessage(
//        roomId: String,
//        content: String
//    ): Result<Unit> {
//        TODO("Not yet implemented")
//    }

}