package ru.asshands.softwire.domain.converters

import ru.asshands.softwire.data.remote.models.HeroApi
import ru.asshands.softwire.data.remote.models.HeroStat
import ru.asshands.softwire.data.storage.models.HeroEntity
import ru.asshands.softwire.domain.models.Hero
import ru.asshands.softwire.domain.models.HeroType

class HeroesConverterImpl: HeroesConverter {

    override fun convertFromApiToDomain(heroApi: HeroApi, heroStat: HeroStat): Hero {
        return Hero(id = heroApi.id, name = heroApi.name, avatar = heroStat.img, heroType = when {
            heroApi.roles.contains("Carry") -> HeroType.Carry
            heroApi.roles.contains("Support") -> HeroType.Support
            heroApi.roles.contains("Durable") -> HeroType.Hardlane
            else -> HeroType.Unknown
        })
    }

    override fun convertFromDbToDomain(heroEntity: HeroEntity): Hero {
        return Hero(id = heroEntity.id, name = heroEntity.displayName, avatar = heroEntity.avatar,
            heroType = when {
                heroEntity.role == HeroType.Carry.name -> HeroType.Carry
                else -> HeroType.Unknown
            })
    }

    override fun convertFromApiToDB(heroApi: HeroApi, heroStat: HeroStat): HeroEntity {
        val role = if (heroApi.roles.isNotEmpty()) {
            heroApi.roles.first()
        } else {
            HeroType.Unknown.name
        }

        return HeroEntity(id = heroApi.id, displayName = heroApi.localized_name,
            avatar = heroStat.img, role = role)
    }
}