package com.rakapermanaptr.data.features.haven.repository

import com.rakapermanaptr.data.features.haven.InboxModel
import com.rakapermanaptr.data.features.haven.RoomMember
import com.rakapermanaptr.data.features.haven.RoomModel
import com.rakapermanaptr.data.features.haven.toDomain
import com.rakapermanaptr.domain.haven.entity.Haven
import com.rakapermanaptr.domain.haven.repository.IHavenRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.from

class HavenRepository(private val supabase: SupabaseClient) : IHavenRepository {

    override suspend fun createHaven(userId: String): Result<String> {
        return runCatching {
            val myId = supabase.auth.currentUserOrNull()?.id ?: throw Exception("Unauthorized")

            // 1. Cek dulu, apakah room antara saya DAN Budi sudah ada?
            // (Opsional untuk mencegah duplikasi room privat)

            // 2. Jika belum ada, buat Room baru di tabel 'rooms'
            val newRoom = supabase.from("rooms").insert(RoomModel(isGroup = false)) {
                select()
            }.decodeSingle<RoomModel>()

            // 3. Masukkan saya dan Budi ke tabel 'room_members'
            val members = listOf(
                RoomMember(roomId = newRoom.id!!, userId = myId),
                RoomMember(roomId = newRoom.id, userId = userId)
            )
            supabase.from("room_members").insert(members)

            newRoom.id // Kembalikan ID room baru untuk navigasi
        }
    }

    override suspend fun getHavenList(): Result<List<Haven>> {
        return runCatching {
            val myId = supabase.auth.currentUserOrNull()?.id ?: throw Exception("Unauthorized")

            supabase.from("user_inbox")
                .select {
                    filter {
                        eq("my_id", myId)
                    }
                }.decodeList<InboxModel>().map { it.toDomain() }
        }
    }


}