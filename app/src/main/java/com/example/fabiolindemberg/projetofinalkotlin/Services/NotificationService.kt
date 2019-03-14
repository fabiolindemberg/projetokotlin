package com.example.fabiolindemberg.projetofinalkotlin.Services

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.example.fabiolindemberg.projetofinalkotlin.Activities.PostDetailActivity
import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post
import com.example.fabiolindemberg.projetofinalkotlin.Http.HttpService
import com.example.fabiolindemberg.projetofinalkotlin.Utils.ConstantUtil
import com.example.fabiolindemberg.projetofinalkotlin.Utils.NotificationUtil
import com.example.fabiolindemberg.projetofinalkotlin.Utils.PreferencesUtil

class NotificationService: IntentService("Post Notification"){
    private val flag = "LAST_POST_ID"

    override fun onHandleIntent(intent: Intent?) {

        val posts: List<Post>
        try {
            posts = HttpService.getAll()
            val prefs = PreferencesUtil(this)
            if (posts.last().id.toString() != prefs.getString(flag)){
                prefs.setString(flag, posts.last().id.toString())
                val intent = Intent(this, PostDetailActivity::class.java)
                intent.putExtra(ConstantUtil.A_POST_KEY, posts.last())
                NotificationUtil.show(this, 100, posts.last().title, posts.last().description, "", intent)
            }
        } catch (e: Exception) {
            Log.e(ConstantUtil.AN_ERROR_TAG, e.message)
        }

    }

}