package com.example.jogodamemriaifpbtsi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jogodamemriaifpbtsi.DAO.DAO
import com.example.jogodamemriaifpbtsi.DAO.ServerCallback
import com.example.jogodamemriaifpbtsi.DAOLocal.JogadorDAO
import com.example.jogodamemriaifpbtsi.model.Jogador
import com.squareup.picasso.Picasso
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var btiniciar : Button
    private lateinit var btiniciarMedio : Button
    private lateinit var btiniciarDificil : Button
    private lateinit var btListarProfessores:Button
    private lateinit var btListarRecords:Button
    private lateinit var dao: JogadorDAO

    private val GAME_HARD = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dao = JogadorDAO(this)

        if(intent.hasExtra("JOGADOR_INSERT")){
//            Log.i("APP_TESTE",intent.getSerializableExtra("JOGADOR_INSERT").toString())
            dao.insert(intent.getSerializableExtra("JOGADOR_INSERT") as Jogador)
            Toast.makeText(this,"Cadastrado record!",Toast.LENGTH_LONG).show()
        }

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
            val it = Intent(this,ListagemProfessorActivity::class.java)
            startActivity(it)
        })

        this.btListarRecords = findViewById(R.id.MainBTListarRecords)
        this.btListarRecords.setOnClickListener({
            var it = Intent(this,ListagemRecordsActivity::class.java)
            var jogadores : ArrayList<Jogador> = dao.getByScore()
            it.putExtra("jogadores",jogadores)
            startActivity(it)
        })

        if(intent.hasExtra("ZERARBD_RECORDS")){
            dao.deleteAll();
            Toast.makeText(this,"Deletado todos os records!",Toast.LENGTH_LONG).show()
        }



    }
}
