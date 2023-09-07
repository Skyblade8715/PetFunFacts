package com.skycom.petfunfacts.data.repository

import com.skycom.petfunfacts.data.remote.CatPicApi
import com.skycom.petfunfacts.domain.repository.CatPicRepo
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class CatPicRepoImpl @Inject constructor(
    private val catPicApi: CatPicApi
) : CatPicRepo {

    override suspend fun getCatPic(): Response<ResponseBody> {
        return catPicApi.getCatPic()
    }

}