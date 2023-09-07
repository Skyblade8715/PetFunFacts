package com.skycom.petfunfacts.di

import com.skycom.petfunfacts.data.remote.CatFactApi
import com.skycom.petfunfacts.data.remote.CatPicApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatFactApi(): CatFactApi {
        return Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatFactApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCatPicApi(): CatPicApi {
        return Retrofit.Builder()
            .baseUrl("https://cataas.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatPicApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideMeowFactsRepo(api: MeowFactsApi, app: Application): MeowFactsRepo {
//        return MeowFactsRepoImpl(api, app)
//    }
}