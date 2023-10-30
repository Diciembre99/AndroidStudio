package com.dam2.simondice

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.gridlayout.widget.GridLayout
import com.dam2.simondice.databinding.ActivityMainBinding
import java.lang.Math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val botones = ArrayList<Button>()
    val botonUser = ArrayList<Button>()
    var nivel = 4
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        generarTablero(nivel)
        binding.tvNivel.text = "Nivel: "+(nivel-3)
        binding.btnComenzar.setOnClickListener{
            tocarBoton()
            botonUser.clear()
            iluminarBoton()
        }
        binding.btnReiniciar.setOnClickListener{
            reiniciar()
        }
    }


    fun reiniciar(){
        //Regresamos los parametros hasta cero
        nivel = 4
        generarTablero(nivel)
        botones.clear()
        botonUser.clear()
        binding.tvNivel.text = "Nivel: "+(nivel-3)
        for (boton in botones) {
            boton.isEnabled = false
        }
    }
    fun verificarGanador(){
        //Comparamos la lista de los botones seleccionados por el jugador y el orden de los que se generaron aleatoriamente
        if (botonUser == botones){
            Toast.makeText(applicationContext,"Felicidades ganaste,avanzas al siguiente nivel",Toast.LENGTH_SHORT).show()
            nivel+=1;
            Log.i("KRCC:::", "Nivel =$nivel")
            botones.clear()
            generarTablero(nivel)
            binding.tvNivel.text = "Nivel: "+(nivel-3)
        }else{
            Toast.makeText(applicationContext, "Te equivocaste, intentalo de nuevo", Toast.LENGTH_SHORT).show()
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    fun tocarBoton(){
        for (i in 0 until binding.gridLayout.childCount){
            val boton = binding.gridLayout.getChildAt(i)
            boton.setOnTouchListener { view, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        // Cuando se presiona el botón, cambia su opacidad
                        if (boton is Button) {
                            boton.alpha = 1.0f
                            // Agrega el botón al ArrayList
                            botonUser.add(boton)
                        }

                    }
                    MotionEvent.ACTION_UP -> {
                        // Cuando se suelta el botón, restaura su opacidad original
                        boton.alpha = 0.4f
                        if (botonUser.size == botones.size) {
                            verificarGanador()
                            botonUser.clear()
                            for (boton in botones) {
                                boton.isEnabled = false
                            }
                        }
                    }
                }
                // Devuelve true para indicar que el evento ha sido manejado
                true
            }
        }
    }
    fun agregarBotones() {
        // Itera a través de todos los elementos dentro de la GridLayout
        for (i in 0 until binding.gridLayout.childCount) {
            val boton = binding.gridLayout.getChildAt(i)
            // Verifica si el elemento es un botón
            if (boton is Button) {
                // Agrega el botón al ArrayList
                botones.add(boton)
            }
        }
    }

    fun iluminarBoton() {
        binding.btnComenzar.isVisible =false
        binding.btnReiniciar.isVisible =false
        Log.i("KRCC:::", "Botones en lista =${botones.size}")
        var totalDelay = 0
        val handler = Handler(Looper.getMainLooper())
        //En caso de que la lista de botones esta vacia generamos una nueva
        if (botones.isEmpty()){
            agregarBotones()
        }
        //Seleccionamos un boton al azar
        botones.shuffle()
        for (boton in botones) {
            val changeOpacityRunnable = Runnable {
                // Cambia la opacidad del botón
                boton.alpha = 1f
                handler.postDelayed({
                    boton.alpha = 0.3f
                }, 2000)
            }
            //Esperamos a que el tiempo se cumpla para ejecutar una nueva instruccion
            handler.postDelayed(changeOpacityRunnable, (2000 * botones.indexOf(boton)).toLong())
            totalDelay += 2000 //acumulamos el tiempo esperado para que los botones se bloqueen ese mismo tiempo
        }
        handler.postDelayed({
            for (boton in botones) {
                boton.isEnabled = true
            }
            binding.btnComenzar.isVisible =true
            binding.btnReiniciar.isVisible =true
        }, totalDelay.toLong()) //Tiempo que se espera para habilitar los botones, asi se habilitan al terminar de mostrar los colores

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun generarTablero(nivel: Int) {
        //Elimina todos los botones del grindLayout antes de generar un nuevo tablero
        binding.gridLayout.removeAllViews()
        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        //Calculamos le ancho del tablero en base al numero de botones, se divide entre 3 para organizarlos y se aproxima hacia arriba
        val anchoTablero: Int = ceil(nivel.toDouble() / 3).toInt()
        //Asignamos las columnas y las filas con el ancho del tablero
        binding.gridLayout.rowCount = anchoTablero
        binding.gridLayout.columnCount = anchoTablero
        Log.i("KRCC:::", "Nivel =$nivel")
        //Generamos los botones y los agregamos a grindlayout
        for (i in 0 until nivel) {
            val boton = Button(this)
            //Desactivamos los botones por defecto
            boton.isEnabled = false
            //Calculamos el ancho de los botones para que se coloquen de forma dinamica
            var anchoBoton = ceil((400 / anchoTablero).toDouble()).toInt()
            //Los pixeles de los botones se calculan segun la dimension de la pantalla del movil, se multiplica por el ancho en pixeles de la figura
            val pixels = ((anchoBoton) * resources.displayMetrics.density).toInt()
            //Enviamos los parametros al nuevo boton
            val params = GridLayout.LayoutParams(
                ViewGroup.LayoutParams(pixels-100, pixels))
            params.setMargins(10, 10, 10, 10)
            boton.layoutParams = params
            //Generamos los colores de los botones de forma aleatoria
            boton.setBackgroundColor(
                Color.rgb(
                    (0..255).random(),
                    (0..255).random(),
                    (0..255).random()
                )
            )
            //Asignamos una transparencia al boton
            boton.alpha = 0.4f;
            gridLayout.addView(boton)
        }
    }


}