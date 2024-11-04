package com.example.telefono.modelo

import android.os.Parcel
import android.os.Parcelable

data class Contacto(
    val id: Int,
    var nombre: String,
    var apellido: String,
    var empresa: String,
    var direccion: String,
    var ciudad: String,
    var estado: String,
    var telefonos: List<Telefono> = listOf(),
    var correos: List<Correo> = listOf(),
    var fotoUrl: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createTypedArrayList(Telefono.CREATOR) ?: listOf(),
        parcel.createTypedArrayList(Correo.CREATOR) ?: listOf(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeString(empresa)
        parcel.writeString(direccion)
        parcel.writeString(ciudad)
        parcel.writeString(estado)
        parcel.writeTypedList(telefonos)
        parcel.writeTypedList(correos)
        parcel.writeString(fotoUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contacto> {
        override fun createFromParcel(parcel: Parcel): Contacto {
            return Contacto(parcel)
        }

        override fun newArray(size: Int): Array<Contacto?> {
            return arrayOfNulls(size)
        }
    }
}
