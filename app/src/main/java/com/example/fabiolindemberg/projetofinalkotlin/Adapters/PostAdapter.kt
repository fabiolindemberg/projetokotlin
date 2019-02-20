package com.example.fabiolindemberg.projetofinalkotlin.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post
import com.example.fabiolindemberg.projetofinalkotlin.R

class PostAdapter(val posts: List<Post>, val onClick: (Post) -> Unit):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        var tvDescription = view.findViewById<TextView>(R.id.tvDescription)
    }

    override fun getItemCount() = posts.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        // Inflate adapter's view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_feed_item, parent, false)
        // returs the viewHolder that contains all vies
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        // get the current post from posts
        val post = posts[position]

        // make bindins
        holder.tvTitle.text = post.title
        holder.tvDescription.text = post.description
        holder.itemView.setOnClickListener{ onClick(post)}

    }
}