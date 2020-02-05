package ru.asshands.softwire.dotacounterpick.presenters
/*
Удалить
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.asshands.softwire.domain.converters.HeroesConverterImpl
import ru.asshands.softwire.dotacounterpick.views.HeroListView
import java.lang.Exception

// 2:27!!!!!!!!!!!!!!!


@InjectViewState
class HeroListPresenter : MvpPresenter<HeroListView>() {
    private val heroesRepositoryImpl = HeroRepositoryImpl(HeroesConverterImpl())

    fun fetchHeroes() {
        viewState.presentLoading()
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val heroes = heroesRepositoryImpl.fetchHeroes().await()
                //TODO make Converter!
                withContext(Dispatchers.Main) {
                    viewState.presentHeroes(heroes)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}


//      Handler().postDelayed({ doAny },3000)  // для примера
*/
/*        val handler = Handler()
        thread {
            Thread.sleep(3000)
            //do any in thread
            handler.post {
                //do any post
            }
        }*//*


*/
