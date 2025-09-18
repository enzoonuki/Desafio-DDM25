package com.example.desafio.model

import android.icu.text.Transliterator.Position

class UsuarioDAOImpl : UsuarioDAO
{
    companion object
    {
        private val usuarios = mutableListOf<Usuario>()
    }

    override fun inserirUsuario(usuario: Usuario)
    {
        usuarios.add(usuario)
    }

    override fun deletaUsuario(position: Int)
    {
        usuarios.removeAt(position);
    }

    override fun obterUsuarios(): List<Usuario>
    {
        return usuarios
    }

}