package com.castillo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castillo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton.setOnClickListener{
            goWindow2()
        }
    }

    private fun goWindow2() {
        var miIntent: Intent = Intent(this,WindowsDataCollect::class.java)
        startActivity(miIntent)
    }

}