package ru.asshands.softwire.data.remote.helpers

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ru.asshands.softwire.data.remote.services.HeroesService

class RetrofitFactory {

    companion object {
        val baseUrl = "https://api.opendota.com/api/"
        val baseImg = "https://api.opendota.com"

        private fun getOkHttpInstance(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC

            return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }

        @UnstableDefault
        private fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
                .addConverterFactory(Json.nonstrict.asConverterFactory(contentType = "application/json".toMediaType()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        fun getHeroesService() = getRetrofitInstance().create(HeroesService::class.java)
    }
}


        /*
Version_1

        private fun getOkHttpInstance(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        }

        @UnstableDefault
        private fun getRetrofitClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
                .addConverterFactory(Json.nonstrict.asConverterFactory(contentType = "application/json".toMediaTypeOrNull()!!))
                //     .addConverterFactory(Json.nonstrict.asConverterFactory(contentType = "application/json".toMediaTypeOrNull()!!))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        @UnstableDefault
        fun getHeroesService() = RetrofitFactory
            .getRetrofitClient().create(HeroesService::class.java)
    }
}*/