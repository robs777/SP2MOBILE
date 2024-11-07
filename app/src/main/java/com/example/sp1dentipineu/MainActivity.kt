package com.example.sp1dentipineu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sp1dentipineu.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private  val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }


    lateinit var txtIrCadastrar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)



        txtIrCadastrar = findViewById(R.id.txtIrCadastrar)
        txtIrCadastrar.setOnClickListener{
            val navegarCadastro = Intent(this,TelaCadastro::class.java)
            startActivity(navegarCadastro)
        }

        binding.btnLogin.setOnClickListener{
            logarUsuario()
        }


    }

    private fun logarUsuario(){
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()

        autenticacao.signInWithEmailAndPassword(email,senha)
            .addOnSuccessListener { authResult->

                startActivity(Intent(this,TelaGeral::class.java))
            }
            .addOnFailureListener{exception->
                AlertDialog.Builder(this)
                    .setTitle("ERROR AO LOGAR")
                    .setMessage("Verifique email ou senha digitados..")
                    .setPositiveButton("Fechar"){dialog,posicao->}
                    .create().show()
            }


    }

}