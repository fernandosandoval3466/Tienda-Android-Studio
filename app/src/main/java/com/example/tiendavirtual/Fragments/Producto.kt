package com.example.tiendavirtual.Fragments

import android.os.Parcel
import android.os.Parcelable

data class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val imagenResourceId: Int
) : Parcelable {
    // Constructor secundario para la reconstrucción desde el Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readInt()
    )

    // Método que escribe las propiedades en el Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeDouble(precio)
        parcel.writeInt(imagenResourceId)
    }

    // Método que describe el contenido (generalmente se deja como 0)
    override fun describeContents(): Int {
        return 0
    }

    // Objeto Companion necesario para que Parcelable funcione
    companion object CREATOR : Parcelable.Creator<Producto> {
        // Crea un nuevo objeto desde un Parcel
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        // Crea un array del tamaño dado
        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }
}