package com.dam2.formulario2activitys.Modulos

import java.io.Serializable

class Usuario (
    val nombre: String,
    val apellido: String,
    val dni: String,
    val gmail: String,
    val contraseña: String
) {
    override fun toString(): String{
        return "Nombre: $nombre\nApellido: $apellido\nDNI: $dni\nCorreo: $gmail\nClave: $contraseña"
    }
}



