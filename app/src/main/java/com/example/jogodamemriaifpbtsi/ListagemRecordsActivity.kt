package com.example.jogodamemriaifpbtsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.jogodamemriaifpbtsi.model.Jogador
import org.json.JSONObject

class ListagemRecordsActivity : AppCompatActivity() {
    private lateinit var listview : ListView
    private lateinit var botaoapagar: Button
    private lateinit var jogadores : MutableList<Jogador>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_records)

        botaoapagar = findViewById(R.id.ListRecordsBTApagar)
        botaoapagar.setOnClickListener({
            var it = Intent(this,MainActivity::class.java)
            it.putExtra("ZERARBD_RECORDS",1)
            startActivity(it)
        })

        this.listview = findViewById(R.id.ListRecordsLVLista)
        if(intent.hasExtra("jogadores")){
            jogadores = intent.getSerializableExtra("jogadores") as ArrayList<Jogador>
            listview.adapter =  ArrayAdapter<Jogador>(this,android.R.layout.simple_list_item_1,jogadores)
        }

    }
}
