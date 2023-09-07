package com.skycom.petfunfacts.domain.repository

import com.skycom.petfunfacts.domain.model.CatFact
import retrofit2.Response

interface CatFactRepo {
    suspend fun getCatFact(): Response<List<CatFact>>
}