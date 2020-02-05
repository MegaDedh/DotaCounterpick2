package ru.asshands.softwire.data.remote.providers

import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault
import ru.asshands.softwire.data.remote.helpers.RetrofitFactory
import ru.asshands.softwire.data.remote.models.HeroApi

class HeroProviderImpl {

    @UnstableDefault
    fun getHeroesList(): Deferred<List<HeroApi>>{
        return RetrofitFactory.getHeroesService().getHeroes()
    }
}