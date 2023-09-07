package com.skycom.petfunfacts.data.remote

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface CatPicApi {

    @GET("/cat")
    suspend fun getCatPic() : Response<ResponseBody>
}