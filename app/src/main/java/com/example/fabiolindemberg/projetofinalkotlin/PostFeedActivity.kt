package com.example.fabiolindemberg.projetofinalkotlin

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.fabiolindemberg.projetofinalkotlin.Adapters.PostAdapter
import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post
import com.example.fabiolindemberg.projetofinalkotlin.Services.PostService
import kotlinx.android.synthetic.main.activity_feed.*

class PostFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        taskPosts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.feed_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    fun startFeedInputActivity(){
        val intent = Intent(this, PostInputActivity::class.java)
        startActivity(intent)
    }

    fun startPostDetailActivity(post: Post){
        val intent = Intent(this, PostDetailActivity::class.java)
        intent.putExtra("aPost", post.toString())
        startActivity(intent)
    }

    private fun taskPosts(){
        val dialog = ProgressDialog.show(this, getString(R.string.app_name), "Aguarde...", false, true)
        object: Thread(){
            override fun run() {
                super.run()
                var posts = PostService.getPosts()
                runOnUiThread(Runnable {
                    setUpRecyclerView(posts)
                    dialog.dismiss()
                })
            }

        }.run()

    }

    fun setUpRecyclerView(posts: List<Post>){
        rvPost.layoutManager = LinearLayoutManager(this)
        rvPost.adapter = PostAdapter(posts, {post: Post -> startPostDetailActivity(post)})
    }
}
