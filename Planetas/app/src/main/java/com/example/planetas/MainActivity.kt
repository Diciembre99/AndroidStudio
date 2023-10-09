package com.example.planetas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btnMercurio: Button
    lateinit var btnVenus: Button
    lateinit var btnTierra: Button
    lateinit var btnMarte: Button
    lateinit var btnJupiter: Button
    lateinit var btnSaturno: Button
    lateinit var btnUrano: Button
    lateinit var btnNeptuno: Button

    lateinit var rbRocosos: RadioButton
    lateinit var rbGigantesGas: RadioButton
    lateinit var rbGigantesHel: RadioButton

    lateinit var tvInfo: TextView
    val planetas = arrayOf(
        Planeta("Mercurio", "Rocoso", 2439.7, 3.7, 0.33, 57.9),
        Planeta("Venus", "Rocoso", 6051.8, 8.87, 4.87, 108.2),
        Planeta("Tierra", "Rocoso", 6371.0, 9.81, 5.97, 149.6),
        Planeta("Marte", "Rocoso", 3389.5, 3.7, 0.64, 227.9),
        Planeta("Júpiter", "Gigante Gaseoso", 71492.0, 24.79, 1898.0, 778.3),
        Planeta("Saturno", "Gigante Gaseoso", 60268.0, 10.44, 568.0, 1427.0),
        Planeta("Urano", "Gigante Helado", 25559.0, 8.69, 86.8, 2871.0),
        Planeta("Neptuno", "Gigante Helado", 24764.0, 11.15, 102.0, 4497.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMercurio = findViewById(R.id.btnMercurio)
        btnVenus = findViewById(R.id.btnVenus)
        btnTierra = findViewById(R.id.btnTierra)
        btnMarte = findViewById(R.id.btnMarte)
        btnJupiter = findViewById(R.id.btnJupiter)
        btnSaturno = findViewById(R.id.btnSaturno)
        btnUrano = findViewById(R.id.btnUrano)
        btnNeptuno = findViewById(R.id.btnNeptuno)

        tvInfo = findViewById(R.id.tvInfo)
        rbRocosos = findViewById(R.id.rbRocoso)
        rbGigantesGas = findViewById(R.id.rbGigantesGas)
        rbGigantesHel = findViewById(R.id.rbGigantesHel)
        rbRocosos.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mostrarRocosos()
            } else {
                ocultarRocosos()
            }
        }
        rbGigantesGas.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mostrarGaseos()
            }else {
                ocultarGaseos()
            }
        }

        rbGigantesHel.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mostrarHelado()
            }else {
                ocultarHelado()
            }
        }
        btnMercurio.setOnClickListener(){
            tvInfo.text = planetas[0].toString()
        }
        btnVenus.setOnClickListener(){
            tvInfo.text = planetas[1].toString()
        }

        btnTierra.setOnClickListener(){
            tvInfo.text = planetas[2].toString()
        }
        btnMarte.setOnClickListener(){
            tvInfo.text = planetas[3].toString()
        }

        btnJupiter.setOnClickListener(){
            tvInfo.text = planetas[4].toString()
        }

        btnSaturno.setOnClickListener(){
            tvInfo.text = planetas[5].toString()
        }
        btnUrano.setOnClickListener(){
            tvInfo.text = planetas[6].toString()
        }

        btnNeptuno.setOnClickListener(){
            tvInfo.text = planetas[7].toString()
        }
    }

    private fun ocultarRocosos() {
        btnTierra.visibility = View.INVISIBLE
        btnVenus.visibility = View.INVISIBLE
        btnMercurio.visibility = View.INVISIBLE
        btnMarte.visibility = View.INVISIBLE
    }

    private fun mostrarRocosos() {
        btnTierra.visibility = View.VISIBLE
        btnVenus.visibility = View.VISIBLE
        btnMercurio.visibility = View.VISIBLE
        btnMarte.visibility = View.VISIBLE
    }

    private fun mostrarGaseos(){
        btnJupiter.visibility = View.VISIBLE
        btnSaturno.visibility = View.VISIBLE
    }
    private fun ocultarGaseos() {
        btnJupiter.visibility = View.INVISIBLE
        btnSaturno.visibility = View.INVISIBLE
    }
    private fun mostrarHelado(){
        btnUrano.visibility = View.VISIBLE
        btnNeptuno.visibility = View.VISIBLE
    }
    private fun ocultarHelado() {
        btnUrano.visibility = View.INVISIBLE
        btnNeptuno.visibility = View.INVISIBLE
    }
}