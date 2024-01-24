package com.example.aristidevcursoapp1.superheroapp

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import java.util.Objects

// Si en mi data class no quiero llamar la primera variable response, puedo utilizar
// SerializedName para especificar el nombre de la variable en el json al cual quiero asignarle

//Si el result comienza por un [ es una lista
//Si el result comienza por un { es una objeto

data class SuperHeroDataResponse(
    @SerializedName("response") val respuesta: String,
    @SerializedName("results") val resultados: List<SuperHeroItemResponse>
)


data class SuperHeroItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val nombre: String,
    @SerializedName("powerstats") val estadisticas: Objects
)