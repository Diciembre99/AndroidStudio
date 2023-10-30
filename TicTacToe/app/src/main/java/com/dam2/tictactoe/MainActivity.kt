package com.dam2.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.dam2.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fila1 = listOf<Button>(
        findViewById(R.id.btn1),
        findViewById(R.id.btn2),
        findViewById(R.id.btn3)
    )
    private val fila2 = listOf<Button>(
        findViewById(R.id.btn4),
        findViewById(R.id.btn5),
        findViewById(R.id.btn6)
    )

    private val fila3 = listOf<Button>(
        findViewById(R.id.btn7),
        findViewById(R.id.btn8),
        findViewById(R.id.btn9)
    )

    private val matrizBotones = listOf(fila1, fila2, fila3)
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        CambiarImagen()


    }

//    fun CambiarImagen(){
//        var turn =0
//        for (i in 0 until binding.gridLayout.childCount){
//            val boton = binding.gridLayout.getChildAt(i) as ImageButton
//
//            boton.setOnClickListener{
//                turn++;
//                if (turn % 2 == 0) {
//                    boton.setImageResource(R.drawable.linx)
//                }else{
//                    boton.setImageResource(R.drawable.wds)
//                }
//            }
//        }
//    }
}