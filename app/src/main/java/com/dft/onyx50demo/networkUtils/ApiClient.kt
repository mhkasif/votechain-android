package com.dft.onyx50demo.networkUtils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private const val baseUrl = "https://vote-chain95.herokuapp.com/"

    val onyxApi: OnyxApi
        get() {
            val httpClient = OkHttpClient.Builder()
                    .readTimeout(30,TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
//                    .addInterceptor(HeaderInterceptor())
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
            return retrofit.create(OnyxApi::class.java)
        }

}


//class HeaderInterceptor : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
//        proceed(
//                request()
//                        .newBuilder()
//                        .addHeader("Content-Type", "application/json")
////                        .addHeader("Auth-token", Common.auth_token ?: "")
//                        .build()
//        )
//    }
//}
