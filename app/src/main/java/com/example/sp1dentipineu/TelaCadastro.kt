package com.example.sp1dentipineu

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sp1dentipineu.databinding.ActivityTelaCadastroBinding
import com.google.firebase.auth.FirebaseAuth

class TelaCadastro : AppCompatActivity() {

    private val binding by lazy {
        ActivityTelaCadastroBinding.inflate(layoutInflater)
    }
    private  val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener {
            cadastrarUsuario()
        }



    }
    private fun cadastrarUsuario() {
        val email = binding.editEmailCadastro.text.toString()
        val senha = binding.editSenhaCadastro.text.toString()



        autenticacao.createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener { authResult ->
                AlertDialog.Builder(this)
                    .setTitle("SUCESSO")
                    .setMessage("Sucesso ao criar conta.")
                    .setPositiveButton("OK") { dialog, posicao ->
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    .setCancelable(false).create().show()

            }.addOnFailureListener { exception ->
                val mensagemErro = exception.message
                AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Error ao criar conta")
                    .setPositiveButton("Fechar") { dialog, posicao -> }
                    .create().show()

            }
    }
}