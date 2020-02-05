package ru.asshands.softwire.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.asshands.softwire.data.storage.contracts.RoomContract

@Entity(tableName = RoomContract.tableHero)
data class HeroEntity(@PrimaryKey val id: Int,
                      val displayName: String,
                      val avatar: String,
                      val role: String)