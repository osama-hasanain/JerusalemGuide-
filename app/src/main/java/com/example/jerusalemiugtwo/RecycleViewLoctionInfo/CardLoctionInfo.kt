package com.example.jerusalemiugtwo.RecycleViewLoctionInfo
 class CardLoctionInfo(){
     lateinit var img:String
     lateinit var title: String
     var type:Int = 0

     constructor(img:String,title:String,type:Int):this(){
         this.img = img
         this.title = title
         this.type=type
     }
 }