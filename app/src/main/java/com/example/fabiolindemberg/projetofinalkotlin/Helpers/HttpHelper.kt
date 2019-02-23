package com.example.fabiolindemberg.projetofinalkotlin.Helpers

import android.util.Log
import okhttp3.*
import java.io.IOException

object HttpHelper {
    private const val TAG = "http"
    private const val LOG_ON = true
    private val JSON = MediaType.parse("application/json; charset=utf-8")
    var client = OkHttpClient()

    fun get(url: String):String {
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    fun post(url: String, json: String):String{
        val request = Request.Builder().url(url).post(RequestBody.create(JSON, json)).build()
        return getJson(request)
    }

    fun postFrom(url: String, params: Map<String, String>):String{
        var builder = FormBody.Builder()

        for ((key, value) in params){
            builder.add(key, value)
        }

        var body = builder.build()

        val request = Request.Builder().url(url).post(body).build()

        return getJson(request)
    }

    private fun getJson(request: Request): String {
        
        val response = client.newCall(request).execute()
        val responseBody = response.body()
        if(responseBody != null){
            val json = responseBody.string()
            return json
        }
        throw IOException("Erro ao fazer requisição")
    }
    /*
    private fun getJson(request: Request): String {
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response): String {
                val responseBody = response.body()
                if(responseBody != null){
                    val json = responseBody.string()

                    Log.d("Funcionou", json)
                    return ""
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("Erro", e.message)
            }
        })
    }
    */

}