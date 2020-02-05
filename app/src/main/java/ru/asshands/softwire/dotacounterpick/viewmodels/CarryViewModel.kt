package ru.asshands.softwire.dotacounterpick.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*
import ru.asshands.softwire.domain.CarryRepository
import ru.asshands.softwire.dotacounterpick.extentions.default
import ru.asshands.softwire.dotacounterpick.extentions.set
import ru.asshands.softwire.dotacounterpick.helpers.State
import java.lang.Exception


class CarryViewModel(val repository: CarryRepository) : LifecycleObserver {
    private val TAG = CarryViewModel::class.java.simpleName

    val state: MutableLiveData<State> =
        MutableLiveData<State>().default(initialValue = State.LoadingState())



    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun fetchCarries() {
        //   val SOURCE = "DB" // Данные из БД через Room
        val SOURCE = "Database" // Данные из сети

        state.set(newValue = State.LoadingState())

        if (SOURCE == "DB") {
            CoroutineScope(Dispatchers.IO).launch {
                val heroes = repository.fetchLocalCarries().await()
                if (heroes.isEmpty()) {
                    launch(Dispatchers.Main) {
                        state.set(newValue = State.NoItemsState())
                    }
                } else {
                    launch(Dispatchers.Main) {
                        state.set(newValue = State.LoadedState(data = heroes))
                    }
                }
            }
        } else {

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val heroes = repository.fetchCarries().await()
                    if (heroes.isEmpty()) {
                        withContext(Dispatchers.Main) {
                            state.set(newValue = State.NoItemsState())
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            state.set(newValue = State.LoadedState(data = heroes))
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "error ${e.localizedMessage}")
                    e.printStackTrace()
                }
            }
        }
    }
}