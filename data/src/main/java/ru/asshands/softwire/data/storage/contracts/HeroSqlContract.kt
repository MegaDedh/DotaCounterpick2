package ru.asshands.softwire.data.storage.contracts

class HeroSqlContract {

    companion object {
        const val fetch = "SELECT * FROM ${RoomContract.tableHero}"

    }
}