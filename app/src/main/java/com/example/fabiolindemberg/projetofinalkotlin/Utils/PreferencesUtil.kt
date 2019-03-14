package com.example.fabiolindemberg.projetofinalkotlin.Utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtil(context: Context) {

    val PREFS_ID = "post"
    var prefs : SharedPreferences

    init {
        this.prefs = context.getSharedPreferences(PREFS_ID,0)
    }

    fun getString(flag: String):String{
        return prefs.getString(flag, "")
    }

    fun setString(flag: String, value: String){
        var editor = prefs.edit()
        editor.putString(flag, value)
        editor.commit()
    }
}