package com.example.telefono.modelo

import android.os.Parcel
import android.os.Parcelable

data class Telefono(
    val numero: String,
    val tipo: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(numero)
        parcel.writeString(tipo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Telefono> {
        override fun createFromParcel(parcel: Parcel): Telefono {
            return Telefono(parcel)
        }

        override fun newArray(size: Int): Array<Telefono?> {
            return arrayOfNulls(size)
        }
    }
}
