package com.example.aristidevcursoapp1.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    //Se crea una funcion asincrona con la palabra reservada suspend
    @GET("api.php/7206958199369604/search/{name}")
    suspend fun getSuperHeroes(@Path("name")superHeroName:String):Response<SuperHeroDataResponse>
    //------------------------------------------------------------
}