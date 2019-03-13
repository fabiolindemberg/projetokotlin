package com.example.fabiolindemberg.projetofinalkotlin.Activities

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post
import com.example.fabiolindemberg.projetofinalkotlin.R
import com.example.fabiolindemberg.projetofinalkotlin.Http.HttpService

class PostInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_input)

        findViewById<Button>(R.id.btnConfirm).setOnClickListener {

            var title = findViewById<TextView>(R.id.etTitle).text.toString() ?: "Title was not informed!"
            var description = findViewById<TextView>(R.id.etDescription).text.toString() ?: "..."

            var post = Post(0, title, description)

            someTask(post).execute()
        }
    }

    internal inner class someTask(post: Post) : AsyncTask<Void, Void, Unit>(){

        var post: Post

        init{
            this.post = post
        }
        override fun doInBackground(vararg p0: Void?): Unit {
            HttpService.post(post)
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            finish()
        }
    }

}
