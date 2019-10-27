package com.example.projetorichgirls

import retrofit2.Call
import retrofit2.http.GET

interface MyService {

        @GET("9cblp")
        fun listarContatos() : Call<List<ContatoModel>>
}
