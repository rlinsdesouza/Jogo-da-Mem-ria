package com.example.jogodamemriaifpbtsi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var teste: TextView
    private lateinit var btiniciar : Button
    private val GAME_HARD = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btiniciar = findViewById(R.id.MainBTIniciar)
        this.btiniciar.setOnClickListener({
            val it = Intent(this,GameHardActivity::class.java)
            startActivity(it)
        })

        this.teste = findViewById(R.id.teste)

        val queue = Volley.newRequestQueue(this)
        val url = "https://apiprofessoresifpbtsi.herokuapp.com/professores/"

//        val stringResquest = StringRequest (
//            Request.Method.GET, url, Response.Listener<String> { response ->
//            teste.text = "response is: ${response.substring(0,500)}"
//        },
//            Response.ErrorListener { teste.text = "Não funcionou" })
//
//        queue.add(stringResquest)

//        queue.add(stringResquest)

//        val jsonArrayResquest = JsonArrayRequest (
//            Request.Method.GET, url, null,
//            Response.Listener { response ->
//                teste.text = "response is: %s".format(response.toString().substring(0,500))
//            },
//            Response.ErrorListener { teste.text = "Não funcionou" })
//
//
//        queue.add(jsonArrayResquest)

        val jsonObjectResquest = JsonObjectRequest (
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val data = response.getJSONArray("results")
                val professores:List<Any>

                teste.text = "response is: %s".format(data.toString().substring(0,500))


//                teste.text = "response is: %s".format(data.getJSONObject(0).toString().substring(0,500))


            },
            Response.ErrorListener { teste.text = "Não funcionou" })


        queue.add(jsonObjectResquest)





    }
}
