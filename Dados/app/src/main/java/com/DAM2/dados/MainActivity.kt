package com.DAM2.dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.DAM2.dados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var winsPlayer1 = 0;
    private var winsPlayer2 = 0;
    private var rollsPlayer1 = 0
    private var rollsPlayer2 = 0
    private var pointsPlayer1 = 0
    private var pointsPlayer2 = 0
    private val MAX_GAMES: Int = 5
    private val drawableList = mapOf(
        1 to R.drawable.dice1,
        2 to R.drawable.dice2,
        3 to R.drawable.dice3,
        4 to R.drawable.dice4,
        5 to R.drawable.dice5,
        6 to R.drawable.dice6
    )

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlayer1.setOnClickListener{
            var randomNumber = randomDice()
            val randomDice = drawableList[randomNumber]
            //Verificamos que el jugador uno no ha superado el maximo de tiradas
            if (rollsPlayer1 < MAX_GAMES){
                //Deforma aleatoria cambiamos la imagen en base a la lista en base a su indice
                randomDice?.let { idImage -> binding.imgDicePlayer1.setImageResource(idImage) }
                //Aumentamos el numero de tiradas que ha jugado el jugador
                rollsPlayer1++
                //Sumamos los puntos acumulados de cada jugador
                pointsPlayer1 += randomNumber
                messagePlayer(binding.txtPointsPlayer1, binding.txtRollsPlayer1,pointsPlayer1,rollsPlayer1)

            }else{
                //Si se han llegado al maximo de tiradas posibles se envia un mensaje al jugador
                Toast.makeText(applicationContext, "Tiradas maximas alcanzadas para el jugador 1", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnPlayer2.setOnClickListener{
            var randomNumber = randomDice()
            val randomDice = drawableList[randomNumber]
            if (rollsPlayer2 < MAX_GAMES){
                randomDice?.let { idImage -> binding.imgDicePlayer2.setImageResource(idImage) }
                rollsPlayer2++
                pointsPlayer2 += randomNumber
                messagePlayer(binding.txtPointsPlayer2, binding.txtRollsPlayer2,pointsPlayer2,rollsPlayer2)
            }else{
                Toast.makeText(applicationContext, "Tiradas maximas alcanzadas para el jugador 2", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnPlayAgain.setOnClickListener{
            if (pointsPlayer1 < MAX_GAMES || pointsPlayer2 < MAX_GAMES) {
                Toast.makeText(applicationContext,"Termina las rondas antes de reiniciar", Toast.LENGTH_SHORT).show()
            }else{
                when {
                    //Definimos si el jugador uno o dos gano la partida y le enviamos un mensaje al ganador
                    pointsPlayer1 < pointsPlayer2 -> {
                        Toast.makeText(applicationContext, "Gano el jugador 2", Toast.LENGTH_SHORT)
                            .show()
                        winsPlayer2++
                    }
                    pointsPlayer2 < pointsPlayer1 -> {
                        Toast.makeText(applicationContext, "Gano el jugador 1", Toast.LENGTH_SHORT)
                            .show()
                        winsPlayer1++
                    }
                    else -> Toast.makeText(applicationContext, "Empate", Toast.LENGTH_SHORT).show()
                }
                resetPoints()
                messagePlayer(binding.txtPointsPlayer1, binding.txtRollsPlayer1, pointsPlayer1, rollsPlayer1)
                messagePlayer(binding.txtPointsPlayer2, binding.txtRollsPlayer2, pointsPlayer2, rollsPlayer2)
                binding.txtWinsPlayer1.text = winsPlayer1.toString()
                binding.txtWinsPlayer2.text = winsPlayer2.toString()
            }
        }
        binding.btnRestar.setOnClickListener{
            //Reiniciamos los contadores de puntos de ambos jugadores
            resetPoints()
            winsPlayer1 = 0
            winsPlayer2 = 0
            //Actualizamos los cuadros de texto de cada jugador
            messagePlayer(binding.txtPointsPlayer1, binding.txtRollsPlayer1,pointsPlayer1,rollsPlayer1)
            messagePlayer(binding.txtPointsPlayer2, binding.txtRollsPlayer2,pointsPlayer2,pointsPlayer2)
            binding.txtWinsPlayer1.text = winsPlayer1.toString()
            binding.txtWinsPlayer2.text = winsPlayer2.toString()
            binding.imgDicePlayer1.setImageResource(R.drawable.dice)
            binding.imgDicePlayer2.setImageResource(R.drawable.dice)
        }
    }

    private fun randomDice() : Int{
        return (1 until 6).random()
    }


    private fun resetPoints() {
        rollsPlayer1 = 0
        rollsPlayer2 = 0
        pointsPlayer1 = 0
        pointsPlayer2 = 0

    }
    private fun messagePlayer(textViewPoints: TextView,textViewRolls: TextView,points :Int, rolls : Int) {
        textViewPoints.text = points.toString()
        textViewRolls.text = rolls.toString()
    }


}

