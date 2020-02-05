package ru.asshands.softwire.dotacounterpick.di

import android.app.Application
import ru.asshands.softwire.data.storage.RoomAppDatabase

class App: Application() {

    companion object{
        lateinit var roomAppDatabase: RoomAppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        roomAppDatabase = RoomAppDatabase.buildDataSource(applicationContext)
    }
}