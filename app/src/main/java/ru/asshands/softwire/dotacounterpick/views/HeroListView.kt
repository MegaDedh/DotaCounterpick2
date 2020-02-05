package ru.asshands.softwire.dotacounterpick.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.asshands.softwire.domain.models.Hero

@StateStrategyType(AddToEndSingleStrategy::class)
interface HeroListView : MvpView{

    fun presentHeroes(data: List<Hero>)
    fun presentLoading()
}