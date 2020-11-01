package com.learnandroid.mvvmloginregsample.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    fun userLogin(@Field("email") email:String,
        @Field("password") password:String
    ): Call<ResponseBody>

    companion object{
        operator fun invoke(): ApiInterface{
            return Retrofit.Builder()
                .baseUrl("https://localhost/loginregapis/Api.php?apicall=/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)


        }
    }

}