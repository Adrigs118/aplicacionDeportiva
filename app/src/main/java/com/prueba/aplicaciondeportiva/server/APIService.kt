package com.prueba.aplicaciondeportiva.server

import com.prueba.aplicaciondeportiva.database.Entity.NotificationEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface APIService {

    //@GET("notifications/{id}")
    //fun getById(@Path("id") id : String) : Call<Notification>

    @GET
    suspend fun getAll(@Url url: String) : Response<List<NotificationEntity>>
}