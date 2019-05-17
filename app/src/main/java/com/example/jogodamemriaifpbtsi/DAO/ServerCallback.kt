package com.example.jogodamemriaifpbtsi.DAO

import org.json.JSONObject

interface ServerCallback {
    fun onSucess(result : MutableList<JSONObject>);
}