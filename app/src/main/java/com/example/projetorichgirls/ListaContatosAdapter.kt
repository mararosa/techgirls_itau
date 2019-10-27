package com.example.projetorichgirls

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista_contato.view.*

class ListaContatosAdapter (var listaContatos : List<ContatoModel>, var context : Context)
    : RecyclerView.Adapter<ItemContatosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContatosViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_lista_contato,
            parent, false)
        return ItemContatosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaContatos.size
    }

    override fun onBindViewHolder(holder: ItemContatosViewHolder, position: Int) {
        val contato = listaContatos[position]
        holder.bindView(contato)
    }
}

class ItemContatosViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(
        contato: ContatoModel
    ) {
        itemView.txt_nome.text = contato.nome

    }
}