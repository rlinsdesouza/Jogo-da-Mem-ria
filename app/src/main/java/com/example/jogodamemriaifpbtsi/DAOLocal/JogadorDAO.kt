package com.example.jogodamemriaifpbtsi.DAOLocal

import android.content.ContentValues
import android.content.Context
import com.example.jogodamemriaifpbtsi.model.Jogador

class JogadorDAO {
    private lateinit var banco:BancoHelper

    constructor(context:Context) {
        this.banco = BancoHelper(context)
    }

    // create
    fun insert(p: Jogador){
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("score", p.score)
        this.banco.writableDatabase.insert("jogador",null, cv)
    }

    // all
    fun get(): ArrayList<Jogador>{
        val colunas = arrayOf("id", "nome", "score")
        val lista = ArrayList<Jogador>()

        val c = this.banco.readableDatabase.query("jogador", colunas, null, null, null, null, "nome")

        c.moveToFirst()

        if (c.count > 0){
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val score = c.getDouble(c.getColumnIndex("score"))
                lista.add(Jogador(id, nome, score))
            }while(c.moveToNext())
        }

        return lista
    }


    fun getByScore(): ArrayList<Jogador>{
        val colunas = arrayOf("id", "nome", "score")
        val lista = ArrayList<Jogador>()

        val c = this.banco.readableDatabase.query("jogador", colunas, null, null, null, null, "score")

        c.moveToFirst()

        if (c.count > 0){
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val score = c.getDouble(c.getColumnIndex("score"))
                lista.add(Jogador(id, nome, score))
            }while(c.moveToNext())
        }

        return lista
    }


    // find
    fun get(index: Int): Jogador?{
        val colunas = arrayOf("id", "nome", "score")
        val where = "id = ?"
        val pwhere = arrayOf(index.toString())

        val c = this.banco.readableDatabase.query("jogador", colunas, where, pwhere, null, null, null)

        c.moveToFirst()

        if (c.count > 0){
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val score = c.getDouble (c.getColumnIndex("score"))
            return Jogador(id, nome, score)
        }

        return null
    }

    // update
    fun update(p: Jogador){
        val where = "id = ?"
        val pwhere = arrayOf(p.id.toString())
        val cv = ContentValues()
        cv.put("id", p.id)
        cv.put("nome", p.nome)
        cv.put("score", p.score)

        this.banco.writableDatabase.update("jogador", cv, where, pwhere)
    }

    // delete
    fun delete(id: Int){
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())

        this.banco.writableDatabase.delete("jogador", where, pwhere)
    }

    fun deleteAll(){
        this.banco.writableDatabase.execSQL("delete from jogador")
    }

}