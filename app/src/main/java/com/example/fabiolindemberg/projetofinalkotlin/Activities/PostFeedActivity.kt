package com.example.fabiolindemberg.projetofinalkotlin.Activities

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.fabiolindemberg.projetofinalkotlin.Adapters.PostAdapter
import com.example.fabiolindemberg.projetofinalkotlin.Services.NotificationService
import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post
import com.example.fabiolindemberg.projetofinalkotlin.R
import com.example.fabiolindemberg.projetofinalkotlin.Http.HttpService
import kotlinx.android.synthetic.main.activity_feed.*

class PostFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        someTask().execute()

        startService(Intent(this, NotificationService::class.java))
    }

    fun setAlarmManager(){

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.feed_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.miNewPost){
            startFeedInputActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    fun startFeedInputActivity(){
        val intent = Intent(this, PostInputActivity::class.java)
        startActivity(intent)
    }

    fun startPostDetailActivity(post: Post){
        val intent = Intent(this, PostDetailActivity::class.java)
        intent.putExtra("aPost", post)
        startActivity(intent)
    }

    fun setUpRecyclerView(posts: List<Post>){
        rvPost.layoutManager = LinearLayoutManager(this)
        rvPost.adapter = PostAdapter(posts, {post: Post -> startPostDetailActivity(post)})
    }

    internal inner class someTask() : AsyncTask<Void, Void, List<Post>>() {
        var posts : List<Post>? = null

        override fun doInBackground(vararg params: Void?): List<Post>? {
            return HttpService.getAll()
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // ...
        }

        override fun onPostExecute(result: List<Post>?) {
            if (result != null) {
                setUpRecyclerView(result)

            }
            super.onPostExecute(result)
        }
    }

    override fun onStart() {
        someTask().execute()
        super.onStart()
    }
}
