package com.example.jogodamemriaifpbtsi.model

import java.io.Serializable

class Jogador : Serializable {
    var id: Int
    var nome:String
    var score:Double

    constructor(id:Int,nome:String,score:Double){
        this.id = id
        this.nome = nome
        this.score = score
    }

    constructor(nome:String,score:Double){
        this.id=-1
        this.nome=nome
        this.score=score
    }

    override fun toString(): String {
        return "${id} - ${nome} - ${score}"
    }
}