package com.example.jogodamemriaifpbtsi.Adapter

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import com.example.jogodamemriaifpbtsi.R
import com.squareup.picasso.Picasso
import org.json.JSONObject

//https://blog.alura.com.br/personalizando-uma-listview-no-android/
class CustomListViewAdapter : BaseAdapter {

    private var context: Context
    private var lista: MutableList<JSONObject>

    constructor(context:Context,lista:MutableList<JSONObject>) {
        this.context = context
        this.lista = lista
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // inflate the layout for each list row
        var view : View
//        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.elementlist_professor , parent, false);
//        }

//        // get current item to be displayed
        var professor : JSONObject = lista.get(position)
        Log.i("APP_TESTE", professor.toString())
//        // get the ItemListView
        var imageViewProfessor : ImageView = view.findViewById(R.id.lista_imagem_professor) as ImageView
        var nomeTVProfessor: TextView = view.findViewById(R.id.lista_professor_nome) as TextView
        var fraseTVProfessor: TextView = view.findViewById(R.id.lista_professor_frase) as TextView

//
//        //sets the text for item name and item description from the current item object
        Picasso.get().load(professor.getString("foto")).into(imageViewProfessor)
        nomeTVProfessor.text = professor.getString("nome")
        fraseTVProfessor.text = professor.getString("frasemarcante")

//        // returns the view for the current row
        return view;
    }

    override fun getItem(position: Int): Any {
        return lista.get(position);
    }

    override fun getItemId(position: Int): Long {
        return 0;
    }

    override fun getCount(): Int {
        return this.lista.size
    }
}