package com.example.desafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.desafio.R
import com.example.desafio.model.Usuario
import com.example.desafio.model.UsuarioDAOImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val dao = UsuarioDAOImpl();
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent);

        var btnCadastro = findViewById<Button>(R.id.btn_salvar)
        var edtNome = findViewById<EditText>(R.id.edt_nome)
        var edtValor = findViewById<EditText>(R.id.edt_valor)
        var edtImagem = findViewById<EditText>(R.id.edt_imagem)
        var fabLista = findViewById<FloatingActionButton>(R.id.fab_lista)

        btnCadastro.setOnClickListener {
            val imagem = edtImagem.text.toString();
            val nome = edtNome.text.toString();
            val valor = edtValor.text.toString();

            val usuario = Usuario(nome, valor, imagem);

            dao.inserirUsuario(usuario);

            val builder = AlertDialog.Builder(this);
            builder.setTitle("Sucesso");
            builder.setMessage("Usuário cadastrado com sucesso.")
            val alert = builder.create()
            alert.show()
            edtNome.text.clear()
            edtValor.text.clear()
            edtImagem.text.clear()
        }

        fabLista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent);
        }
    }
}