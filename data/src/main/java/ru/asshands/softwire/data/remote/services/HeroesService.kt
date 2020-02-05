package ru.asshands.softwire.data.remote.services

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import ru.asshands.softwire.data.remote.models.HeroApi
import ru.asshands.softwire.data.remote.models.HeroStat

interface HeroesService {


    @GET("./heroes")
    fun getHeroes(): Deferred<List<HeroApi>>

    @GET("./heroStats")
    fun getHeroesStats(): Deferred<List<HeroStat>>
}