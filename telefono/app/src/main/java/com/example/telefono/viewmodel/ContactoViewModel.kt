package com.example.telefono.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.telefono.modelo.Contacto
import com.example.telefono.repositorio.ContactoRepository
import kotlinx.coroutines.launch

class ContactoViewModel(private val repository: ContactoRepository) : ViewModel() {
    val contactos: MutableLiveData<List<Contacto>> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()

    fun cargarContactos() {
        val viewModelScope = null
        viewModelScope!!.launch {
            try {
                val resultado = repository.getContactos()
                contactos.value = resultado
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }

    fun actualizarContacto(id: Int, contacto: Contacto) {
        val viewModelScope = null
        viewModelScope!!.launch {
            try {
                repository.updateContacto(id, contacto)
                cargarContactos()
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }

    fun eliminarContacto(id: Int) {
        val viewModelScope = null
        viewModelScope!!.launch {
            try {
                repository.deleteContacto(id)
                cargarContactos()
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }
}
