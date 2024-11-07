package com.example.sp1dentipineu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sp1dentipineu.databinding.ActivityTelaSintomasBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaSintomas : AppCompatActivity() {

    private val binding by lazy {
        ActivityTelaSintomasBinding.inflate(layoutInflater)
    }

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    private val bancoDados by lazy {
        FirebaseFirestore.getInstance()
    }


    lateinit var btnIrScanner: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        btnIrScanner= findViewById(R.id.btnIrScanner)
        btnIrScanner.setOnClickListener{
            val navegarLogin = Intent(this,TelaCamera::class.java)
            startActivity(navegarLogin)
        }


        binding.btnDescSintomas.setOnClickListener {
            salvarInfo()
        }


    }



        private fun salvarInfo() {
        val dados = mapOf(
            "descricaoSintomas" to binding.editDescSintomas.text.toString()
        )

        val idUsuarioAtual = autenticacao.currentUser?.uid

        if (idUsuarioAtual != null) {
            bancoDados
                .collection("sintomas")
                .document(idUsuarioAtual)
                .set(dados)
                .addOnSuccessListener {
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO")
                        .setMessage("Descrição salva com sucesso.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }
                .addOnFailureListener {
                    AlertDialog.Builder(this)
                        .setTitle("ERROR AO DETALHAR SINTOMA")
                        .setMessage("Descrição do sintoma não salvo.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }
        }

    }

}