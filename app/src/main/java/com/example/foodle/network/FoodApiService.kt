package com.example.foodle.network

import com.example.foodle.model.FoodData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://cs371m.herokuapp.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FoodApiService {
    // jcl
    @GET("retrieveMenuData?name=jcl&meal=Breakfast")
    suspend fun getJclBreakfast(): List<FoodData>
    @GET("retrieveMenuData?name=jcl&meal=Lunch")
    suspend fun getJclLunch(): List<FoodData>
    @GET("retrieveMenuData?name=jcl&meal=Dinner")
    suspend fun getJclDinner(): List<FoodData>

    // jesta' pizza
    @GET("retrieveMenuData?name=jizza&meal=Breakfast")
    suspend fun getJizzaBreakfast(): List<FoodData>
    @GET("retrieveMenuData?name=jizza&meal=Lunch")
    suspend fun getJizzaLunch(): List<FoodData>
    @GET("retrieveMenuData?name=jizza&meal=Dinner")
    suspend fun getJizzaDinner(): List<FoodData>

    // kins
    @GET("retrieveMenuData?name=kins&meal=Breakfast")
    suspend fun getKinsBreakfast(): List<FoodData>
    @GET("retrieveMenuData?name=kins&meal=Lunch")
    suspend fun getKinsLunch(): List<FoodData>
    @GET("retrieveMenuData?name=kins&meal=Dinner")
    suspend fun getKinsDinner(): List<FoodData>

    // J2
    @GET("retrieveMenuData?name=j2&meal=Breakfast")
    suspend fun getJ2Breakfast(): List<FoodData>
    @GET("retrieveMenuData?name=j2&meal=Lunch")
    suspend fun getJ2Lunch(): List<FoodData>
    @GET("retrieveMenuData?name=j2&meal=Dinner")
    suspend fun getJ2Dinner(): List<FoodData>

    // Littlefield
    @GET("retrieveMenuData?name=littlefield&meal=Breakfast")
    suspend fun getLittlefieldBreakfast(): List<FoodData>
    @GET("retrieveMenuData?name=littlefield&meal=Lunch")
    suspend fun getLittlefieldLunch(): List<FoodData>
    @GET("retrieveMenuData?name=littlefield&meal=Dinner")
    suspend fun getLittlefieldDinner(): List<FoodData>

}

object FoodApi {
    val retrofitService : FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java) }
}