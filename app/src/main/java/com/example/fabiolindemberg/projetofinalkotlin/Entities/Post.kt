package com.example.fabiolindemberg.projetofinalkotlin.Entities

import java.io.Serializable

data class Post(var id: Int, var title: String, var description: String) : Serializable {}