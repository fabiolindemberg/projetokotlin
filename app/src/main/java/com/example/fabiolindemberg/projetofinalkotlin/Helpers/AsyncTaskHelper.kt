package com.example.fabiolindemberg.projetofinalkotlin.Helpers

import android.os.AsyncTask
import com.example.fabiolindemberg.projetofinalkotlin.Entities.Post

class Task(getPosts: () -> List<Post>, syncResult: (any: Any)->Void) : AsyncTask<Void, Void, List<Post>>(){

    val getPosts: () -> List<Post>
    val syncResult: (posts: List<Post>)->Void

    init {
        this.getPosts = getPosts
        this.syncResult = syncResult
    }

    override fun doInBackground(vararg p0: Void?): List<Post>? {
        return this.getPosts()
    }

    override fun onPostExecute(result: List<Post>?) {
        if (result != null) { syncResult(result) }

        super.onPostExecute(result)
    }

}