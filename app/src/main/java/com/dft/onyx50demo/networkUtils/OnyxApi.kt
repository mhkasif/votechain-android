package com.dft.onyx50demo.networkUtils

import com.dft.onyx50demo.response.CastVoteRequest
import com.dft.onyx50demo.response.CastVoteResponse
import com.dft.onyx50demo.response.ValidationRequest
import com.dft.onyx50demo.response.ValidationResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface OnyxApi {

    @POST("validate")
    fun validate(
            @Body body: ValidationRequest
    ): Call<ValidationResponse>

    @Multipart
    @POST("fingerprint")
    fun fingerprint(
            @Part("voter_id") voter_id:RequestBody,
            @Part("index") index:RequestBody,
            @Part data:MultipartBody.Part
    )

    @POST("caste-vote")
    fun castVote(
            @Body body: CastVoteRequest
    ): Call<CastVoteResponse>


}