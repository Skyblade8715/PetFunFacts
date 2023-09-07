package com.skycom.petfunfacts.data.remote

import com.skycom.petfunfacts.domain.model.CatFact
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatFactApi {

    @GET("/facts/random")
    suspend fun getCatFact(@Query("amount") amount: Int) : Response<List<CatFact>>
}