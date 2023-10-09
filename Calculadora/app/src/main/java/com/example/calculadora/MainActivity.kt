package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edNum1 : EditText
    lateinit var edNum2 : EditText
    lateinit var edResultado : EditText
    lateinit var edResto : EditText

    lateinit var btnSumar : Button
    lateinit var btnRestar : Button
    lateinit var btnMultiplicar : Button
    lateinit var btnDividir : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var numero1 = 0
        var numero2 = 0
        var resultado = 0
        edNum1 = findViewById(R.id.edNum1)
        edNum2 = findViewById(R.id.edNum2)
        edResultado = findViewById(R.id.edResultado)
        edResto = findViewById(R.id.edResto)

        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)

        btnSumar.setOnClickListener {
            numero1 = Integer.parseInt(edNum1.text.toString())
            numero2 = Integer.parseInt(edNum2.text.toString())
            resultado  = numero1 + numero2
            edResultado.setText(resultado.toString());
        }
    }


}