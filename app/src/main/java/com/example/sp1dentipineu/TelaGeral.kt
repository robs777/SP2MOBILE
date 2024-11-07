package com.example.sp1dentipineu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaGeral : AppCompatActivity() {

    lateinit var buttonConsulta: ImageView

    lateinit var textConsulta: TextView

    lateinit var buttonDiag: ImageView

    lateinit var textDiag: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_geral)

        buttonConsulta = findViewById(R.id.imgConsulta)
        buttonConsulta.setOnClickListener{
            val navegarLogin = Intent(this,TelaAgenda::class.java)
            startActivity(navegarLogin)
        }

        textConsulta = findViewById(R.id.textConsulta)
        textConsulta.setOnClickListener{
            val navegarLogin = Intent(this,TelaAgenda::class.java)
            startActivity(navegarLogin)
        }


        buttonDiag = findViewById(R.id.imgDiag)
        buttonDiag.setOnClickListener{
            val navegarLogin = Intent(this,TelaSintomas::class.java)
            startActivity(navegarLogin)
        }


        textDiag = findViewById(R.id.textDiag)
        textDiag.setOnClickListener{
            val navegarLogin = Intent(this,TelaSintomas::class.java)
            startActivity(navegarLogin)
        }





    }
}