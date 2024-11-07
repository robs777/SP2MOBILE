package com.example.sp1dentipineu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaCamera : AppCompatActivity() {

    lateinit var btnIrAgenda: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_camera)

        btnIrAgenda = findViewById(R.id.btnIrAgenda)
        btnIrAgenda.setOnClickListener{
            val navegarLogin = Intent(this,TelaAgenda::class.java)
            startActivity(navegarLogin)
        }





    }
}