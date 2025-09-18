package com.example.desafio.model

import android.media.Image
import android.widget.ImageView

interface UsuarioDAO {
    fun inserirUsuario(usuario: Usuario)
    fun deletaUsuario(position: Int)
    fun obterUsuarios(): List<Usuario>

}