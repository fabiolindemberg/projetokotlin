package com.example.fabiolindemberg.projetofinalkotlin.Http

import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post
import com.example.fabiolindemberg.projetofinalkotlin.Extensions.fromJson
import com.example.fabiolindemberg.projetofinalkotlin.Extensions.toJson
import com.example.fabiolindemberg.projetofinalkotlin.Helpers.HttpHelper

object HttpService{

    private const val BASE_URL = "http://ec2-18-231-122-154.sa-east-1.compute.amazonaws.com:8080/post"

    fun getAll(): List<Post> {
        val posts = fromJson<List<Post>>(HttpHelper.get(BASE_URL))
        return posts
    }

    fun post(post: Post){
        val json = post.toJson()
        HttpHelper.post(BASE_URL, json)
    }

}