package com.example.projetorichgirls

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_lista_contato.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaContatosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contato)

       // var nomes = ArrayList<String>()
        // nomes.add("Ana")
        // nomes.add("Luiza")

        buscaListaContato()


    }

    private fun buscaListaContato() {

        val call = RetrofitInitialize().myService().listarContatos()
        call.enqueue(object : Callback<List<ContatoModel>?> {

            override fun onResponse(
                call: Call<List<ContatoModel>?>,
                response: Response<List<ContatoModel>?>) {

                response?.body()?.let {
                    var listaContatos : List<ContatoModel> = it
                    exibirLista(listaContatos)

                }

                Log.i("techgirl", "Lista retornada com sucesso")

            }

            override fun onFailure(
                call: Call<List<ContatoModel>?>,
                t: Throwable) {

                Log.e("techgirl", t?.message)
            }



        })
    }

    private fun exibirLista(listaContatos: List<ContatoModel>) {

        rv_lista_contatos.adapter = ListaContatosAdapter(listaContatos, this)

        val layourManager = StaggeredGridLayoutManager( 1, StaggeredGridLayoutManager.VERTICAL)
        rv_lista_contatos.layoutManager = layourManager
    }
}

