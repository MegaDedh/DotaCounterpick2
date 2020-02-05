package ru.asshands.softwire.data.storage.dao

import androidx.room.Dao
import androidx.room.Query
import ru.asshands.softwire.data.storage.contracts.AntipickSqlContract
import ru.asshands.softwire.data.storage.contracts.RoomContract
import ru.asshands.softwire.data.storage.models.AntipickEntity

@Dao
interface AntipickDao {

    @Query("SELECT * FROM ${RoomContract.tableAntipick} WHERE id = :id")
    fun fetchAntipicks(id: Int): List<AntipickEntity>
}