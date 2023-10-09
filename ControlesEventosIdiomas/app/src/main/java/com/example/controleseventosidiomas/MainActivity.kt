package com.example.controleseventosidiomas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnRight: Button
    lateinit var txt:TextView
    lateinit var  btnCentro:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var textoCentral: TextView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCentro.setOnClickListener {
            Toast.makeText(this, "Este texto sale desde el centro", Toast.LENGTH_SHORT).show()
        }


    }
    fun ChambiarTextoIzq(v:View){
        var textoIzquierda: TextView = findViewById(R.id.labelCentral)
        textoIzquierda.text = "Ya casi finaliza viernes :)"
    }

    fun ChambiarTextoDer(v:View){
        var textoIzquierda: TextView = findViewById(R.id.labelCentral)
        textoIzquierda.text = "Ya es lunes :("
    }
}