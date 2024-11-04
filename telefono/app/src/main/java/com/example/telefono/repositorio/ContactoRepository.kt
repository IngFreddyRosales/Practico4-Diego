package com.example.telefono.repositorio

import com.example.telefono.api.ApiService
import com.example.telefono.modelo.Contacto

class ContactoRepository(private val api: ApiService) {
    suspend fun getContactos(): List<Contacto> {
        // Aquí deberías manejar la llamada a la API para obtener contactos.
        return api.getContactos() // Asegúrate de que este método exista en ApiService
    }

    suspend fun createContacto(contacto: Contacto) {
        api.createContacto(contacto) // Asegúrate de que este método exista en ApiService
    }

    suspend fun updateContacto(id: Int, contacto: Contacto) {
        api.updateContacto(id, contacto) // Asegúrate de que este método exista en ApiService
    }

    suspend fun deleteContacto(id: Int) {
        api.deleteContacto(id) // Asegúrate de que este método exista en ApiService
    }
}
