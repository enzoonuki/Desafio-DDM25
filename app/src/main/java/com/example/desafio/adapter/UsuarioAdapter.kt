package com.example.desafio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio.R
import com.example.desafio.model.Usuario
import com.example.desafio.model.UsuarioDAOImpl
import com.example.desafio.view.ListaActivity

class UsuarioAdapter(private val usuarios: MutableList<Usuario>) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>()
{
    var dao = UsuarioDAOImpl();
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNome: TextView = itemView.findViewById(R.id.item_nome)
        val textViewValor: TextView = itemView.findViewById(R.id.item_valor)
        val imgViewImagem: ImageView = itemView.findViewById(R.id.item_img)
        val holderView = itemView
        val btnDelete: Button = itemView.findViewById(R.id.btn_delete)
        val btnUpdate: Button = itemView.findViewById(R.id.btn_edit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.textViewNome.text = usuario.nome
        holder.textViewValor.text = usuario.valor
        Glide.with(holder.holderView.context.applicationContext).load(usuario.imagem).into(holder.imgViewImagem)

        holder.btnDelete.setOnClickListener {
            dao.deletaUsuario(position)
        }
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }
}