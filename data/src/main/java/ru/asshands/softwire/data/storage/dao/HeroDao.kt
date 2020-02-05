package ru.asshands.softwire.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.asshands.softwire.data.storage.contracts.HeroSqlContract
import ru.asshands.softwire.data.storage.models.HeroEntity

@Dao
interface HeroDao {

    @Query(HeroSqlContract.fetch)
    fun fetchHeroes(): List<HeroEntity>

    @Insert(entity = HeroEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertHero(heroEntity: HeroEntity)
}