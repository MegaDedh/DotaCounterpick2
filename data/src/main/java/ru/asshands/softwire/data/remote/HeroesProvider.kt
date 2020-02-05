package ru.asshands.softwire.data.remote

import kotlinx.coroutines.Deferred
import ru.asshands.softwire.data.remote.models.HeroApi
import ru.asshands.softwire.data.remote.models.HeroStat

interface HeroesProvider {
    suspend fun fetchHeroes(): Deferred<List<HeroApi>>
    suspend fun fetchHeroStats(): Deferred<List<HeroStat>>
}