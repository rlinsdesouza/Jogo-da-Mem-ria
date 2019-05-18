package com.example.jogodamemriaifpbtsi

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.jogodamemriaifpbtsi.DAO.DAO
import com.example.jogodamemriaifpbtsi.DAO.ServerCallback
import com.squareup.picasso.Picasso
import org.json.JSONObject

class GameHardActivity : AppCompatActivity() {
    private var ListImageView : MutableList<ImageView> = ArrayList<ImageView>()
    private lateinit var gridview : GridView
    private lateinit var baseImagens: List<Object>
    private lateinit var ImagensEmJogo: List<String>

    private lateinit var primeiroClick : Integer
    private lateinit var segundoClick : Integer
    private lateinit var NumeroImagem: Integer

    private lateinit var pontos : Integer

    private lateinit var professores : MutableList<JSONObject>
    private lateinit var dao: DAO
    private var qntCartas : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_hard)
        this.dao = DAO(this)
        dao.getProfessores(object : ServerCallback {
            override fun onSucess(result: MutableList<JSONObject>) {
               professores = result
               Log.e("APP_TESTE",professores.toString())
            }
        })
//        Log.e("APP_TESTE",professores.toString())

    }


    override fun onResume() {
        super.onResume()
        var imageView : ImageView = ImageView(this)
        var adapter: ArrayAdapter<ImageView>

        this.gridview = findViewById(R.id.GameGVid)
        for(i in 0..16) {
            imageView.setImageResource(R.drawable.duvida)
            imageView.setTag(i)
            this.ListImageView.add(imageView)
        }
        adapter = ArrayAdapter(this,R.layout.imageview_cartaprofessor ,this.ListImageView)
        this.gridview.adapter = adapter
//        for(professor:JSONObject in professores) {
//            imageView = ImageView(this)
//            imageView.setImageResource(R.drawable.duvida)
//            imageView.setTag(professor.getString("foto"))
//        }
//            this.imagem1.setOnClickListener({
//            Picasso.get().load("http://res.cloudinary.com/deqmrmqui/image/upload/v1557696533/kpry3ib3h3tu06dxbqdf.jpg").into(this.imagem1)
//        })
    }

    fun verificaClick () {

    }
}
