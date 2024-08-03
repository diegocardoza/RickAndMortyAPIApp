package com.diegocardoza.rickandmortyapiapp.data

import com.diegocardoza.rickandmortyapiapp.data.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyAPIService {

    @GET("/api/character/")
    suspend fun getAllCharacters(@Query("page") page: Int): ResponseWrapper

}