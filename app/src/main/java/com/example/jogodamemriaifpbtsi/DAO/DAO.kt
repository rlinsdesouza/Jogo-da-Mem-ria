package com.example.jogodamemriaifpbtsi.DAO

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class DAO {
    val context: Context

    constructor(context: Context){
        this.context = context
    }


    fun getProfessores (callback: ServerCallback) {

        val queue = Volley.newRequestQueue(this.context)
        val url = "https://apiprofessoresifpbtsi.herokuapp.com/professores/"

        val jsonObjectResquest = JsonObjectRequest (
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val data: JSONArray = response.getJSONArray("results")
                val professores:MutableList<JSONObject> = ArrayList()
                for (i in (0..data.length()-1)) {
                    professores.add(data.getJSONObject(i))
                }
                callback.onSucess(professores)
            },
            Response.ErrorListener {
                Log.e("APP_TESTE","Nao funcionou a requisicao dos professores")
            })
        queue.add(jsonObjectResquest)
    }
}