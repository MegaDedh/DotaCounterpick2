package ru.asshands.softwire.domain.repositories.implementation

//import kotlinx.coroutines.Deferred
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.async
//import ru.asshands.softwire.data.remote.providers.HeroProviderImpl
//import ru.asshands.softwire.domain.converters.HeroesConverterImpl
//import ru.asshands.softwire.domain.models.Hero
//
//class HeroRepositoryImpl(private val heroConverter: HeroesConverterImpl) {
//
//    private val heroProvider = HeroProviderImpl()
//
//    suspend fun fetchHeroes(): Deferred<List<Hero>> {
//        return try {
//            val heroes = heroProvider.getHeroesList().await()
//            GlobalScope.async {
//                heroes.map { hero -> heroConverter.fromApiToUi(model = hero) }
//            }
//        } catch (e: Exception) {
//            GlobalScope.async { error(e) }
//        }


/*      Thread.sleep(2000)
        val mockData = ArrayList<Hero>()
        mockData.add(Hero(id = 0, title = "Anti-Mage", icon = "", attackType = 0))
        mockData.add(Hero(id = 1, title = "Dark-Willow", icon = "", attackType = 1))
        mockData.add(Hero(id = 2, title = "Lion", icon = "", attackType = 1))
        return GlobalScope.async { mockData }*/

//    }
//}