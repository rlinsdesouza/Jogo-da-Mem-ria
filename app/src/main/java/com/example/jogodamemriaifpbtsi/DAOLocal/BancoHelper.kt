package com.example.jogodamemriaifpbtsi.DAOLocal

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper (context: Context) :
                    SQLiteOpenHelper(context,"bancojogomemoria",null,1){


    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table jogador ("+
                      "id integer primary key autoincrement,"+
                "nome text, score real)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}