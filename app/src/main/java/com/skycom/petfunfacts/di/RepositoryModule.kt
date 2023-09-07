package com.skycom.petfunfacts.di

import com.skycom.petfunfacts.data.repository.CatFactRepoImpl
import com.skycom.petfunfacts.data.repository.CatPicRepoImpl
import com.skycom.petfunfacts.domain.repository.CatFactRepo
import com.skycom.petfunfacts.domain.repository.CatPicRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCatFactRepo(
        catFactRepoImpl: CatFactRepoImpl
    ) : CatFactRepo

    @Binds
    @Singleton
    abstract fun bindCatPicRepo(
        catPicRepoImpl: CatPicRepoImpl
    ) : CatPicRepo
}