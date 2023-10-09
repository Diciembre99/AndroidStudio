package com.castillo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castillo.databinding.ActivityMainBinding
import com.castillo.databinding.ActivityWindowsDataCollectBinding
import modulos.AlmacenPersona
import modulos.Persona

class WindowsDataCollect : AppCompatActivity() {
    lateinit var  binding : ActivityWindowsDataCollectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWindowsDataCollectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nombre = intent.getStringExtra("nombre")
        var edad = intent.getStringExtra("edad")
        var persona:Persona = Persona(nombre,edad)

        AlmacenPersona.aniadirPersona(persona)
        binding.cajaNombre.setText(nombre)
        binding.cajaEdad.setText(edad)

        var cadena: String = ""
        var i:Int = 1
        for (p in AlmacenPersona.personas){
            cadena +=  " "+ i + " "+p.nombre  +" " + p.edad +"\n"
            i++
            binding.multiLine.setText(cadena)
        }
        binding.boton.setOnClickListener{
            finish()
        }
    }
}