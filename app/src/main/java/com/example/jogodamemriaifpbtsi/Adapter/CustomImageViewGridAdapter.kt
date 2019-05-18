package com.example.jogodamemriaifpbtsi.Adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.jogodamemriaifpbtsi.R
import org.json.JSONObject

//https://blog.alura.com.br/personalizando-uma-listview-no-android/
class CustomImageViewGridAdapter : BaseAdapter {

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
            view = LayoutInflater.from(context).inflate(R.layout.imageview_cartaprofessor, parent, false);
//        }

//        // get current item to be displayed
        var jsonobject : JSONObject = lista.get(position)

//        // get the ImageView for item name and item description
        var imageViewItemFoto : ImageView = view.findViewById(R.id.ImageViewFlag) as ImageView
//
//        //sets the text for item name and item description from the current item object
        imageViewItemFoto.setImageResource(R.drawable.duvida)
        imageViewItemFoto.tag = jsonobject.getString("foto")

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