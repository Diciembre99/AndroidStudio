package com.dam2.formulario2activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dam2.formulario2activitys.Modulos.UsuarioSingleton
import com.dam2.formulario2activitys.databinding.ActivityConfirmationBinding
import com.dam2.formulario2activitys.databinding.ActivityMainBinding

class ConfirmatioActivity : AppCompatActivity() {
    lateinit var binding: ActivityConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val stringBuilder = StringBuilder()

        for (usuario in UsuarioSingleton.listaUsuarios) {
            stringBuilder.append("Nombre: ${usuario.nombre.toString()} \n")
            stringBuilder.append("Apellido: ${usuario.apellido} \n")
            stringBuilder.append("DNI: ${usuario.dni} \n")
            stringBuilder.append("Correo: ${usuario.gmail} \n")
            stringBuilder.append("Clave: ${usuario.contraseña} \n\n")
        }

        binding.multiTextInfoUsuario.setText(stringBuilder.toString())

        binding.btnRegresar.setOnClickListener{
            finish()
        }
    }
}