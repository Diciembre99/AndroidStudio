package com.dam2.encuesta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Toast
import com.dam2.encuesta1.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listaDatos: MutableList<String> = mutableListOf()
        var contador : Int = 0
        var datos :String = ""
        binding.swAnonimo.setOnCheckedChangeListener{buttonView,isChecked ->
            if (isChecked) {

                binding.txtNombre.isEnabled = false
                binding.txtNombre.setText("Anonimo")
            } else {
                binding.txtNombre.isEnabled = true
            }

        }
        binding.seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar,progress : Int, fromUser : Boolean) {
                //Limite de la progressBar es de 10, hacemos que su progreso llegue hasta ese maximo
                var progreso = binding.seekBar.progress / 10
                binding.tvNum.text = progreso.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.btnValidar.setOnClickListener{
            if (binding.panelRb.checkedRadioButtonId != -1 && binding.cbAsir.isChecked || binding.cbDam.isChecked || binding.cbDaw.isChecked){
                contador++;
                //Concaqutenamos los datos a la varible "Datos" y quede un solo String
                var datos = "Encuesta $contador ("
                //Concateno con un += el signo ${} sirve para poder agregar la coma y el espacio al final y quede mas organizado
                datos += "${binding.txtNombre.text}, "
                val rbSeleccionado = binding.panelRb.checkedRadioButtonId
                val radioButtonSeleccionado = findViewById<RadioButton>(rbSeleccionado)
                datos += "${radioButtonSeleccionado.text}, "
                if (binding.cbAsir.isChecked){
                    datos += "${binding.cbAsir.text}, "
                }
                if (binding.cbDam.isChecked){
                    datos += "${binding.cbDam.text}, "
                }
                if (binding.cbDaw.isChecked){
                    datos += "${binding.cbDaw.text}, "
                }
                datos += binding.tvNum.text.toString()
                datos += ")"
                listaDatos.add(datos)
                Log.i("[ KEVIN CASTILLO ]", datos)
                limpiar()
            }else{
                Toast.makeText(applicationContext,"Debes rellenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnReiniciar.setOnClickListener{
            contador = 0
            listaDatos.clear()
            limpiar()
        }
        binding.btnResumen.setOnClickListener{
            binding.tvTexto.text = listaDatos.joinToString(separator = "\n")
        }
        binding.btnCuentas.setOnClickListener{
            Toast.makeText(applicationContext, "${contador} Entrevistas realizadas", Toast.LENGTH_SHORT).show()
        }
    }

    fun limpiar() {
        binding.tvTexto.text = ""
        binding.swAnonimo.isChecked =false
        binding.cbAsir.isChecked = false
        binding.cbDam.isChecked = false
        binding.cbDaw.isChecked = false
        binding.panelRb.clearCheck()
        binding.txtNombre.setText("")
        binding.tvNum.text = "0"
        binding.seekBar.progress = 0

    }

}