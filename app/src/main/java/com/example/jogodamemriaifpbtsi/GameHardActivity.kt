package com.example.jogodamemriaifpbtsi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class GameHardActivity : AppCompatActivity() {
    private lateinit var imagem1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_hard)

        this.imagem1 = findViewById(R.id.ImagensIV11)
        this.imagem1.setOnClickListener({
            Toast.makeText(this,"Teste ok",Toast.LENGTH_LONG).show()
            imagem1.setImageURI(Uri.parse("https://apiprofessoresifpbtsi.herokuapp.com/media/alana.jpg"))
        })



    }
}
