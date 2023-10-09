package com.castillo.seekprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.castillo.seekprogressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ed1.setText("Hola")
        binding.sb2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                binding.ed1.setText("Cambiando progreso")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                binding.ed2.setText("Cambiando progreso mientras deslizo")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.ed3.setText("Dejo de deslizar")
            }
        })

        binding.sb1.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser:Boolean){
                binding.ed1.setText("Cambiando progreso")
                var progreso = binding.pb1.progress / 10.0
                binding.pb1.progress = progreso.toInt()
                binding.ed2.setText(progreso.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                binding.ed2.setText("Cambiando progreso mientras deslizo")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.ed3.setText("Dejo de deslizar")
            }
        }

        )
    }


}