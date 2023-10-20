package com.dam2.formulario2activitys.Modulos

object UsuarioSingleton {
    val listaUsuarios: ArrayList<Usuario> = ArrayList()

    fun agregarUsuario(usuario: Usuario) {
        listaUsuarios.add(usuario)
    }

    fun obtenerUsuarios(): List<Usuario> {
        return listaUsuarios
    }

}