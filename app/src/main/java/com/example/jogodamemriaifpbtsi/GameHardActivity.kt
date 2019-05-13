package com.example.jogodamemriaifpbtsi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class GameHardActivity : AppCompatActivity() {
    private lateinit var imagem1 : ImageView
    private lateinit var imagem2 : ImageView
    private lateinit var imagem3 : ImageView
    private lateinit var imagem4 : ImageView
    private lateinit var imagem5 : ImageView
    private lateinit var imagem6 : ImageView
    private lateinit var imagem7 : ImageView
    private lateinit var imagem8 : ImageView
    private lateinit var imagem9 : ImageView
    private lateinit var imagem10 : ImageView
    private lateinit var imagem11: ImageView
    private lateinit var imagem12: ImageView
    private lateinit var imagem13 : ImageView
    private lateinit var imagem14 : ImageView
    private lateinit var imagem15 : ImageView
    private lateinit var imagem16 : ImageView

    private lateinit var baseImagens: List<Object>
    private lateinit var ImagensEmJogo: List<String>

    private lateinit var primeiraImagem : Integer
    private lateinit var segundaImagem : Integer
    private lateinit var primeiroClick : Integer
    private lateinit var segundoClick : Integer
    private lateinit var NumeroImagem: Integer

    private lateinit var pontos : Integer





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
