package com.example.fabiolindemberg.projetofinalkotlin.AndroidServices

import android.app.IntentService
import android.app.Service
import android.content.Intent
import com.example.fabiolindemberg.projetofinalkotlin.PostDetailActivity
import com.example.fabiolindemberg.projetofinalkotlin.Services.PostService
import com.example.fabiolindemberg.projetofinalkotlin.Utils.Prefs
import com.example.fabiolindemberg.projetofinalkotlin.Utils.NotificationUtil

class NotificationService: IntentService("Post Notification"){
    override fun onHandleIntent(intent: Intent?) {
        Thread.sleep(10000)
        val posts = PostService.getAll()
        val prefs = Prefs(this)
        val flag = "KEY"
        if (posts.last().id.toString() != prefs.getString(flag)){
            prefs.setString(flag, posts.last().id.toString())
            val intent = Intent(this, PostDetailActivity::class.java)
            intent.putExtra("aPost", posts.last())
            NotificationUtil.show(this, 100, posts.last().title, posts.last().description, "", intent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_STICKY
    }

}