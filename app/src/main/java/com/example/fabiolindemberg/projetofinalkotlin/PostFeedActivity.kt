package com.example.fabiolindemberg.projetofinalkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        setUpRecyclerView()
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

    fun setUpRecyclerView(){
        rvPost.layoutManager = LinearLayoutManager(this)
        rvPost.adapter = PostAdapter(PostService.getPosts(), {post: Post -> startPostDetailActivity(post)})
    }
}
