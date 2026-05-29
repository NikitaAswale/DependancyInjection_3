package com.example.dependancyinjection_3

data class Post (

   val users : List<Posts>
)

data class Posts(
    val userId : Int,
    val id : Int,
    val title : String,
    val body : String,
)