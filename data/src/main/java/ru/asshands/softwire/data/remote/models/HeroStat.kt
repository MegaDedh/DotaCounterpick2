package ru.asshands.softwire.data.remote.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.Json


@Serializable
data class HeroStat(val id: Int, var img: String, var icon: String)