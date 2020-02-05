package ru.asshands.softwire.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.asshands.softwire.data.storage.contracts.RoomContract
import ru.asshands.softwire.data.storage.dao.AntipickDao
import ru.asshands.softwire.data.storage.dao.HeroDao
import ru.asshands.softwire.data.storage.models.AntipickEntity
import ru.asshands.softwire.data.storage.models.HeroEntity
import java.security.AccessControlContext

@Database(entities = [AntipickEntity::class, HeroEntity::class], version = 1)
abstract class RoomAppDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun abtipickDao(): AntipickDao

    companion object{
        fun buildDataSource(context: Context): RoomAppDatabase = Room.databaseBuilder(
            context, RoomAppDatabase::class.java, RoomContract.databaseApp).build()
    }
}