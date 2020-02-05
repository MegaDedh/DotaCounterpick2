package ru.asshands.softwire.dotacounterpick.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_carry.*
import ru.asshands.softwire.data.remote.HeroesProvider
import ru.asshands.softwire.data.remote.implementations.HeroesProviderImpl
import ru.asshands.softwire.domain.converters.HeroesConverter
import ru.asshands.softwire.domain.converters.HeroesConverterImpl


import ru.asshands.softwire.domain.models.Hero
import ru.asshands.softwire.domain.repositories.implementation.CarryRepositoryImpl
import ru.asshands.softwire.dotacounterpick.R
import ru.asshands.softwire.dotacounterpick.adapters.AdapterData
import ru.asshands.softwire.dotacounterpick.adapters.HeroClickHandler
import ru.asshands.softwire.dotacounterpick.adapters.HeroListAdapter
import ru.asshands.softwire.dotacounterpick.di.App
import ru.asshands.softwire.dotacounterpick.helpers.Keys
import ru.asshands.softwire.dotacounterpick.helpers.State
import ru.asshands.softwire.dotacounterpick.viewmodels.CarryViewModel

class CarryFragment :Fragment() {

    private val heroesConverter: HeroesConverter = HeroesConverterImpl()
    private val heroesProvider: HeroesProvider = HeroesProviderImpl()
    private val viewModel = CarryViewModel(repository = CarryRepositoryImpl(heroesConverter = heroesConverter,
        roomAppDatabase = App.roomAppDatabase, heroesProvider = heroesProvider)
    )
    private lateinit var mAdapter: HeroListAdapter
    private val TAG = CarryFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
        mAdapter = HeroListAdapter()
        mAdapter.attachClickHandler(object : HeroClickHandler {
            override fun onItemClick(item: Hero) {
                val bundle = Bundle()
                bundle.putParcelable(Keys.Hero.title, item)
                recyclerCarries.findNavController().navigate(R.id.carryAntipickFragment, bundle)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_carry, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerCarries.layoutManager = GridLayoutManager(context, 4)
        recyclerCarries.adapter = mAdapter
        recyclerCarries.recycledViewPool.setMaxRecycledViews(0, 0)

        viewModel.state.observe(this@CarryFragment,
            Observer<State> { newValue ->
                when (newValue) {
                    is State.LoadedState<*> -> {
                        (mAdapter as AdapterData<Hero>).setData(items = newValue.data.map { it as Hero })

                        cpbCarry.visibility = View.GONE
                        llCarryLoaded.visibility = View.VISIBLE
                        txtNoItems.visibility = View.GONE
                    }
                    is State.NoItemsState -> {
                        cpbCarry.visibility = View.GONE
                        llCarryLoaded.visibility = View.GONE
                        txtNoItems.visibility = View.VISIBLE
                    }
                    is State.LoadingState -> {
                        cpbCarry.visibility = View.VISIBLE
                        llCarryLoaded.visibility = View.GONE
                        txtNoItems.visibility = View.GONE
                    }
                    is State.ErrorState -> Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            })
    }
}