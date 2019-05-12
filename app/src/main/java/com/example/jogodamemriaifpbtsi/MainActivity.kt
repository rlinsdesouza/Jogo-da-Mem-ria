package com.example.jogodamemriaifpbtsi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var view: ImageView
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

        this.view = findViewById(R.id.teste)
        this.view.setImageURI(Uri.parse("https://apiprofessoresifpbtsi.herokuapp.com/media/alana.jpg"))



    }
}
