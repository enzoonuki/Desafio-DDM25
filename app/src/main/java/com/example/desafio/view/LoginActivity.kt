package com.example.desafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.desafio.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fabLogin = findViewById<FloatingActionButton>(R.id.fab_login)
        val nome = findViewById<EditText>(R.id.editTextText)
        val senha = findViewById<EditText>(R.id.editTextText2)

        fabLogin.setOnClickListener {
            if (nome.text.toString() == "Name" && senha.text.toString() == "Pass")
            {
                finish()
            }
            else
            {
                val builder = AlertDialog.Builder(this);
                builder.setTitle("Erro");
                builder.setMessage("Usuário errado.")
                val alert = builder.create()
                alert.show()
            }
        }
    }
}