package com.example.etudiants.retrofit

import com.example.etudiants.pojo.EtuItem
import retrofit2.Response
import retrofit2.http.GET


interface IntEtu {
    @GET("a854dea6-b046-435a-969b-b5dbc6a1e456")
    suspend fun getEtudiant(): Response<EtuItem>

    @GET("01f7fecc-a8f1-4c30-9f56-e95f4c47183c")
    suspend fun getAllEtudiants(): Response<ArrayList<EtuItem>>
}