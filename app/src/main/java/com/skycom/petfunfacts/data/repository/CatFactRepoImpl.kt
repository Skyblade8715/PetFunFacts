package com.skycom.petfunfacts.data.repository

import com.skycom.petfunfacts.data.remote.CatFactApi
import com.skycom.petfunfacts.domain.model.CatFact
import com.skycom.petfunfacts.domain.repository.CatFactRepo
import retrofit2.Response
import javax.inject.Inject

class CatFactRepoImpl @Inject constructor(
    private val catFactApi: CatFactApi
) : CatFactRepo {

    override suspend fun getCatFact() : Response<List<CatFact>> {
        //Magic number "20" facts, as I am still not sure about the API - it happens to return a lot
        //of not verified data which is usually not very funny.
        return catFactApi.getCatFact(20)
    }
}