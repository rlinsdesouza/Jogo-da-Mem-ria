package com.example.jogodamemriaifpbtsi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jogodamemriaifpbtsi.DAO.DAO
import com.example.jogodamemriaifpbtsi.DAO.ServerCallback
import com.squareup.picasso.Picasso
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var btiniciar : Button
    private lateinit var btiniciarMedio : Button
    private lateinit var btiniciarDificil : Button
    private lateinit var btListarProfessores:Button

    private val GAME_HARD = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btiniciar = findViewById(R.id.MainBTIniciar)
        this.btiniciar.setOnClickListener({
            val it = Intent(this,GameHardActivity::class.java)
            it.putExtra("NIVEL",4)
            startActivity(it)
        })

        this.btiniciarMedio = findViewById(R.id.MainBTIniciarMedio)
        this.btiniciarMedio.setOnClickListener({
            val it = Intent(this,GameHardActivity::class.java)
            it.putExtra("NIVEL",8)
            startActivity(it)
        })

        this.btiniciarDificil = findViewById(R.id.MainBTIniciarDificil)
        this.btiniciarDificil.setOnClickListener({
            val it = Intent(this,GameHardActivity::class.java)
            it.putExtra("NIVEL",16)
            startActivity(it)
        })

        this.btListarProfessores = findViewById(R.id.MainBTListarProfessores)
        this.btListarProfessores.setOnClickListener({
            val it = Intent()
        })



    }
}
