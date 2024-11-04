package com.example.telefono.api

import com.example.telefono.modelo.Contacto
import retrofit2.http.*

interface ApiService {
    @GET("api/contactos") // Cambia la ruta según tu API
    suspend fun getContactos(): List<Contacto>

    @POST("api/contactos")
    suspend fun createContacto(@Body contacto: Contacto)

    @PUT("api/contactos/{id}")
    suspend fun updateContacto(@Path("id") id: Int, @Body contacto: Contacto)

    @DELETE("api/contactos/{id}")
    suspend fun deleteContacto(@Path("id") id: Int)
}
