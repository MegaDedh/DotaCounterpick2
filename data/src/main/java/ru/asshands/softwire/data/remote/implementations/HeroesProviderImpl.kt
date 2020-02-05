package ru.asshands.softwire.data.remote.implementations

import kotlinx.coroutines.Deferred
import ru.asshands.softwire.data.remote.HeroesProvider
import ru.asshands.softwire.data.remote.helpers.RetrofitFactory
import ru.asshands.softwire.data.remote.models.HeroApi
import ru.asshands.softwire.data.remote.models.HeroStat

class HeroesProviderImpl : HeroesProvider {
    private val TAG = HeroesProviderImpl::class.java.simpleName

    override suspend fun fetchHeroes(): Deferred<List<HeroApi>> {
        return RetrofitFactory.getHeroesService().getHeroes()
    }

    override suspend fun fetchHeroStats(): Deferred<List<HeroStat>> {
        return RetrofitFactory.getHeroesService().getHeroesStats()
    }
}