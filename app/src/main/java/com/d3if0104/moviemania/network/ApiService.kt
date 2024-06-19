package com.d3if0104.moviemania.network

import com.d3if0104.moviemania.model.Movie
import com.d3if0104.moviemania.model.MessageResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://movie-mania-ryvn.vercel.app/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface UserApi {
    @Multipart
    @POST("movies/")
    suspend fun addData(
        @Part("nama") nama: RequestBody,
        @Part("durasi") durasi: RequestBody,
        @Part("review") review: RequestBody,
        @Part("user_email") userEmail: RequestBody,
        @Part file: MultipartBody.Part
    ): Movie
    @GET("movies/")
    suspend fun getAllData(
        @Query("email") email: String,
    ): List<Movie>

    @DELETE("movies/{movie_id}")
    suspend fun deleteData(
        @Path("movie_id") id: Int,
        @Query("email") email: String
    ): MessageResponse
}


object Api {
    val userService: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    fun getImageUrl(imageId: String): String{
        return BASE_URL + "movies/images/$imageId"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }