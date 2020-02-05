package ru.asshands.softwire.domain

import kotlinx.coroutines.Deferred
import ru.asshands.softwire.domain.models.Hero

interface CarryRepository {
    suspend fun fetchCarries(): Deferred<List<Hero>>
    suspend fun fetchLocalCarries(): Deferred<List<Hero>>
}