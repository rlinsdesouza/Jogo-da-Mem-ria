package com.example.jogodamemriaifpbtsi

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.jogodamemriaifpbtsi.Adapter.CustomImageViewGridAdapter
import com.example.jogodamemriaifpbtsi.DAO.DAO
import com.example.jogodamemriaifpbtsi.DAO.ServerCallback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.imageview_cartaprofessor.view.*
import org.json.JSONObject

class GameHardActivity : AppCompatActivity() {
    private lateinit var gridview : GridView

    private var primeiroClick : ImageView? = null
    private var segundoClick : ImageView? = null


    private lateinit var professores : MutableList<JSONObject>
    private lateinit var dao: DAO
    private var qntCartas : Int = 4
    private lateinit var errosTV: TextView
    private var erros : Int = 0
    private var acertos :Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_hard)
        this.qntCartas = intent.getIntExtra("NIVEL",8)
        this.errosTV = findViewById(R.id.GameMistakes)

        this.dao = DAO(this)
        dao.getProfessores(object : ServerCallback {
            override fun onSucess(result: MutableList<JSONObject>) {
               professores = result
               professores = geraCartas(professores,qntCartas)
                var adapter: CustomImageViewGridAdapter = CustomImageViewGridAdapter(this@GameHardActivity,professores)
                var gridview : GridView = findViewById(R.id.GameGVid)
                gridview.adapter = adapter

            }
        })


        this.gridview = findViewById(R.id.GameGVid)

        this.gridview.setOnItemClickListener(OnClickImageView())
    }

    fun geraCartas (professores: MutableList<JSONObject>,qntCartas : Int): MutableList<JSONObject> {
        var professoresalterado:MutableList<JSONObject> = professores

        professoresalterado.shuffle()
        professoresalterado = professoresalterado.subList(0,qntCartas/2)
        professoresalterado.addAll(professoresalterado)
        professoresalterado.shuffle()
        return professoresalterado
    }

    inner class OnClickImageView : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val professor = parent?.getChildAt(position)?.ImageViewFlag
            Picasso.get().load(professor?.tag as String).into(professor)
            if(primeiroClick == null || segundoClick != null) {
                if(segundoClick == null){
                    primeiroClick = professor
                    primeiroClick!!.setClickable(true);
                }else{
                    primeiroClick!!.setImageResource(R.drawable.duvida)
                    primeiroClick!!.setClickable(false);
                    primeiroClick == null
                    segundoClick!!.setImageResource(R.drawable.duvida)
                    segundoClick!!.setClickable(false);
                    segundoClick = null
                    primeiroClick = professor
                    primeiroClick!!.setClickable(true);
                }
//                professor.setClickable(false);
            }else {
                segundoClick = professor
                if(primeiroClick!!.tag.equals(segundoClick!!.tag)){
                    primeiroClick!!.setClickable(true);
                    segundoClick!!.setClickable(true);
                    primeiroClick = null
                    segundoClick = null
                    acertos++
                    if(acertos == (intent.getIntExtra("NIVEL",8)/2)) {
                        Toast.makeText(this@GameHardActivity, "Finish",Toast.LENGTH_LONG).show()
                    }
                }else{
                    erros++
                    errosTV.text = erros.toString()
                    segundoClick!!.setClickable(true);
                }
            }
        }

    }

}
