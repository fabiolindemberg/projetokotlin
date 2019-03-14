package com.example.fabiolindemberg.projetofinalkotlin.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post
import com.example.fabiolindemberg.projetofinalkotlin.R
import com.example.fabiolindemberg.projetofinalkotlin.Utils.ConstantUtil

class PostDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

         val intent = getIntent()
        val post = intent.getSerializableExtra(ConstantUtil.A_POST_KEY) as Post

        if(post != null){
            findViewById<TextView>(R.id.tvTitle).text = post.title
            findViewById<TextView>(R.id.tvDescription).text = post.description
        }
    }
}
