package com.example.fabiolindemberg.projetofinalkotlin.Utils

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {

    val PREFS_ID = "post"
    val context: Context = context

    private fun prefs(): SharedPreferences {
        return this.context.getSharedPreferences(PREFS_ID,0)
    }

    fun getString(flag: String):String{
        return prefs().getString(flag, "")
    }

    fun setString(flag: String, value: String){
        prefs().edit().putString(flag, value)
    }
}