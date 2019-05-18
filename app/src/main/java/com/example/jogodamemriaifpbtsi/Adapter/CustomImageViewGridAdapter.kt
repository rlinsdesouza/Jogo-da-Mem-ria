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

class CustomImageViewGridAdapter : BaseAdapter {

    private lateinit var context: Context
    private lateinit var lista: List<ImageView>

    constructor(context:Context,lista:ArrayList<ImageView>) {
        this.context = context
        this.lista = lista
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // inflate the layout for each list row
        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.imageview_cartaprofessor, parent, false);
//        }
//
//        // get current item to be displayed
//        currentItem : ImageView = (ImageView) getItem(position)
//
//        // get the TextView for item name and item description
//        TextView textViewItemName = (TextView)
//        convertView.findViewById(R.id.text_view_item_name);
//        TextView textViewItemDescription = (TextView)
//        convertView.findViewById(R.id.text_view_item_description);
//
//        //sets the text for item name and item description from the current item object
//        textViewItemName.setText(currentItem.getItemName());
//        textViewItemDescription.setText(currentItem.getItemDescription());
//
//        // returns the view for the current row
//        return convertView;
//    }
//        }
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return this.lista.size
    }


}