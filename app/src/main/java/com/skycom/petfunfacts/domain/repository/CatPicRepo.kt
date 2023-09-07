package com.skycom.petfunfacts.domain.repository

import okhttp3.ResponseBody
import retrofit2.Response


interface CatPicRepo {
    suspend fun getCatPic(): Response<ResponseBody>
}