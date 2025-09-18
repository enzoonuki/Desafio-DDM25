package com.example.desafio.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.R
import com.example.desafio.adapter.UsuarioAdapter
import com.example.desafio.model.UsuarioDAOImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity() {
    private val dao = UsuarioDAOImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvUsuario = findViewById<RecyclerView>(R.id.rv_usuarios)
        var usuarios = dao.obterUsuarios()
        usuarios = usuarios.toMutableList();
        var fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta);
        rvUsuario.layoutManager = LinearLayoutManager(this)
        rvUsuario.adapter = UsuarioAdapter(usuarios)

        fabVolta.setOnClickListener {
            finish();
        }
    }
}