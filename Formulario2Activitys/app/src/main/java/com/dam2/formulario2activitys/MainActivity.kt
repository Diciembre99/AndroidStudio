package com.dam2.formulario2activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dam2.formulario2activitys.Modulos.Usuario
import com.dam2.formulario2activitys.Modulos.UsuarioSingleton
import com.dam2.formulario2activitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val listaDNI: MutableList<String> = mutableListOf()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistro.setOnClickListener {
            if (validarCampos() && validarDNI(binding.txtDNI.toString()) && validarClave()) {
                val nombre = binding.txtNombre.text.toString()
                val apellido = binding.txtApellido.text.toString()
                val dni = binding.txtDNI.text.toString()
                val correo = binding.txtCorreo.text.toString()
                val clave = binding.txtClave.text.toString()
                val nuevoUsuario = Usuario(nombre, apellido, dni, correo, clave)
                UsuarioSingleton.agregarUsuario(nuevoUsuario)
                listaDNI.add(binding.txtDNI.toString())
                var miIntent: Intent = Intent(this, ConfirmatioActivity::class.java)
                startActivity(miIntent)
            }
        }

    }

    fun validarCampos(): Boolean {
        //Verificamos que todos los campos esten completos
        return when {
            binding.txtNombre.text.isEmpty() -> false
            binding.txtApellido.text.isEmpty() -> false
            binding.txtClave.text.isEmpty() -> false
            binding.txtCorreo.text.isEmpty() -> false
            binding.txtConfirmacionClave.text.isEmpty() -> false
            binding.txtDNI.text.isEmpty() -> false
            else -> true
        }
    }
    fun validarDNI(dni: String): Boolean {
        if (dni in listaDNI) {
            Toast.makeText(applicationContext, "El DNI ya existe", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }

    }
    fun validarClave(): Boolean {
        val clave = binding.txtClave.text.toString()
        val claveConfirmacion = binding.txtConfirmacionClave.text.toString()
        return if (clave == claveConfirmacion) {
            if (binding.txtClave.length() > 6) {
                true
            } else {
                Toast.makeText(
                    applicationContext,
                    "la clave debe tener al menos 6 caracteres",
                    Toast.LENGTH_SHORT
                ).show()
                false
            }
        } else {
            Toast.makeText(applicationContext, "las claves no coinciden", Toast.LENGTH_SHORT).show()
            false
        }
    }

}