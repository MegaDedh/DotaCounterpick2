package ru.asshands.softwire.domain.converters

import ru.asshands.softwire.data.remote.models.HeroApi
import ru.asshands.softwire.data.remote.models.HeroStat
import ru.asshands.softwire.data.storage.models.HeroEntity
import ru.asshands.softwire.domain.models.Hero

interface HeroesConverter {
    fun convertFromApiToDomain(heroApi: HeroApi, heroStat: HeroStat): Hero
    fun convertFromApiToDB(heroApi: HeroApi, heroStat: HeroStat): HeroEntity
    fun convertFromDbToDomain(heroEntity: HeroEntity): Hero
}