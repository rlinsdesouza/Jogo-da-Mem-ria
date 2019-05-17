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

        val dao = DAO(this)
        dao.getProfessores(object : ServerCallback{
            override fun onSucess(result: MutableList<JSONObject>) {
                Log.e("APP_TEST", result.toString())
            }
        })


    }
}
