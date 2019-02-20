package com.example.fabiolindemberg.projetofinalkotlin.Extensions

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

/*
* Convert Any object to json
* */
fun Any.toJson(prettyPrinting: Boolean = false):String{
    val builder = GsonBuilder()
    if(prettyPrinting){
        builder.setPrettyPrinting()
    }
    val json = builder.create().toJson(this)

    return json
}

/*
* Convert a json to Any object
* */
inline fun <reified T> Any.fromJson(json: String): T{
    val type = object: TypeToken<T>() {}.type
    return Gson().fromJson<T>(json, type)
}