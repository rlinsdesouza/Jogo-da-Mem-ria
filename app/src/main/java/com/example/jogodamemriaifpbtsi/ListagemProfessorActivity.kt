package com.example.jogodamemriaifpbtsi

import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodamemriaifpbtsi.Adapter.CustomImageViewGridAdapter
import com.example.jogodamemriaifpbtsi.Adapter.CustomListViewAdapter
import com.example.jogodamemriaifpbtsi.DAO.DAO
import com.example.jogodamemriaifpbtsi.DAO.ServerCallback
import kotlinx.android.synthetic.main.activity_listagem_professor.*
import org.json.JSONObject

class ListagemProfessorActivity : AppCompatActivity() {
    private lateinit var listview : ListView

    private lateinit var professores : MutableList<JSONObject>
    private lateinit var dao: DAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_professor)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        this.dao = DAO(this)
        dao.getProfessores(object : ServerCallback {
            override fun onSucess(result: MutableList<JSONObject>) {
                professores = result
                var adapter: CustomListViewAdapter = CustomListViewAdapter(this@ListagemProfessorActivity,professores)
                var listview : ListView = findViewById(R.id.ListProfessores)
                listview.adapter = adapter
            }
        })
    }
}
