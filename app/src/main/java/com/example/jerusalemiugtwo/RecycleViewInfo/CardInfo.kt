package com.example.jerusalemiugtwo.RecycleViewInfo

import java.io.Serializable

class CardInfo () : Serializable{
   lateinit var id:String
   lateinit var img:String
   lateinit var title:String
   lateinit var desc:String
   constructor(id:String,img:String,title:String,desc:String):this(){
       this.id = id
       this.img = img
       this.title = title
       this.desc = desc
   }
 }