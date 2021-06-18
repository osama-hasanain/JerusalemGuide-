package com.example.jerusalemiugtwo.model

import java.io.Serializable

class NewsItem() : Serializable {

    lateinit var  link  : String
    lateinit var  img  : String
    lateinit var  title  : String
    lateinit var  details  : String
    lateinit var  desc  : String
    lateinit var  date  : String

    constructor(link:String,img:String,title:String,details:String,desc:String,date:String):this(){
        this.link = link
        this.img = img
        this.title = title
        this.details = details
        this.desc = desc
        this.date = date
    }
}