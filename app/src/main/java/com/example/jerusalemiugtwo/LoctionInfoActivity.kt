package com.example.jerusalemiugtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jerusalemiugtwo.RecycleViewLoctionInfo.CardLoctionInfo
import com.example.jerusalemiugtwo.RecycleViewLoctionInfo.CardLoctionInfoAdapter
import kotlinx.android.synthetic.main.activity_loction_info.*

class LoctionInfoActivity : AppCompatActivity(),CardLoctionInfoAdapter.onClick {

    var  address : String? = ""

    override fun onCreate(savedInstanceState: Bundle?){
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loction_info)

        back_but.setOnClickListener {
            finish()
        }

        address = intent.getStringExtra("titleLoction")
        getListLoctionInfo()

    }

    private fun getListLoctionInfo(){
        if (address.equals("مساجد")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.l1,"مصلى الاقصى القديم"))
            data.add(CardLoctionInfo(R.drawable.l2,"المصلى المرواني"))
            data.add(CardLoctionInfo(R.drawable.l3,"جامع البراق"))
            data.add(CardLoctionInfo(R.drawable.l4,"جامع المغاربة (المتحف الاسلامي)"))
            data.add(CardLoctionInfo(R.drawable.l5,"جامع النساء"))
            data.add(CardLoctionInfo(R.drawable.l6,"جامع عيسى"))
            data.add(CardLoctionInfo(R.drawable.l7,"الجامع القبلي"))
            data.add(CardLoctionInfo(R.drawable.l8,"مسجة قبة الصعود"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }else if (address.equals("مدارس تاريخية")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.s1,"ثانوية الأقصى الشرعية"))
            data.add(CardLoctionInfo(R.drawable.s2,"مدارس ورياض الأقصى الإسلامية"))
            data.add(CardLoctionInfo(R.drawable.s3,"المدرسة الباسطية"))
            data.add(CardLoctionInfo(R.drawable.s4,"المدرسة الغادرية"))
            data.add(CardLoctionInfo(R.drawable.s5,"المدرسة الامينية"))
            data.add(CardLoctionInfo(R.drawable.s6,"المدرسة الملكية"))
            data.add(CardLoctionInfo(R.drawable.s7,"المدرسة العثمانية"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }else if (address.equals("بوابات الاقصى")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.d1,"باب حطة"))
            data.add(CardLoctionInfo(R.drawable.d2,"باب الأسباط"))
            data.add(CardLoctionInfo(R.drawable.d3,"باب العتم"))
            data.add(CardLoctionInfo(R.drawable.d4,"باب الغوانمة"))
            data.add(CardLoctionInfo(R.drawable.d5,"باب الناظر"))
            data.add(CardLoctionInfo(R.drawable.d6,"باب الحديد"))
            data.add(CardLoctionInfo(R.drawable.d7,"باب القطانين"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }else if (address.equals("القباب")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.q1,"قبة الصخرة"))
            data.add(CardLoctionInfo(R.drawable.q2,"قبة السلسلة"))
            data.add(CardLoctionInfo(R.drawable.q3,"قبة المعراج"))
            data.add(CardLoctionInfo(R.drawable.q4,"قبة موسى"))
            data.add(CardLoctionInfo(R.drawable.q5,"قبة سليمان"))
            data.add(CardLoctionInfo(R.drawable.q6,"قبة النحوية"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }else if (address.equals("معالم اخرى")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.m1,"منبر نور الدين"))
            data.add(CardLoctionInfo(R.drawable.m2,"منبر برهان الدين"))
            data.add(CardLoctionInfo(R.drawable.m3,"الرواق الغربي"))
            data.add(CardLoctionInfo(R.drawable.m4,"الرواق الشمالي"))
            data.add(CardLoctionInfo(R.drawable.m5,"مصاطب المسجد الاقصى المبارك"))
            data.add(CardLoctionInfo(R.drawable.m6,"الزاوية الختنية"))
            data.add(CardLoctionInfo(R.drawable.m7,"محراب داوود"))
            data.add(CardLoctionInfo(R.drawable.m8,"المتحف الاسلامي"))
            data.add(CardLoctionInfo(R.drawable.m9,"متحف فلسطين الاثري"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }else if (address.equals("مآذن الأقصى")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.a1,"مئذنة باب الأسباط"))
            data.add(CardLoctionInfo(R.drawable.a2,"مئذنة باب الغوانمة"))
            data.add(CardLoctionInfo(R.drawable.a3,"مئذنة الفخرية"))
            data.add(CardLoctionInfo(R.drawable.a4,"مئذنة باب السلسلة"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }else if (address.equals("أسبلة الأقصى")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.e1,"سبيل الكأس"))
            data.add(CardLoctionInfo(R.drawable.e2,"سبيل شعلان"))
            data.add(CardLoctionInfo(R.drawable.e3,"سبيل البصيري"))
            data.add(CardLoctionInfo(R.drawable.e4,"سبيل قايتباي"))
            data.add(CardLoctionInfo(R.drawable.e4,"سبيل قاسم باشا"))
            data.add(CardLoctionInfo(R.drawable.e6,"سبيل سليمان"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }else if (address.equals("بوائك الأقصى")){
            val data = mutableListOf<CardLoctionInfo>()
            data.add(CardLoctionInfo(R.drawable.b1,"البائكةالشمالية"))
            data.add(CardLoctionInfo(R.drawable.b2,"البائكة الغربية"))
            data.add(CardLoctionInfo(R.drawable.b3,"البائكة الجنوبية"))
            data.add(CardLoctionInfo(R.drawable.b4,"البائكة الشرقية"))

            rvLoctionInfo.layoutManager = LinearLayoutManager(this)
            rvLoctionInfo.setHasFixedSize(true)

            val Adapter = CardLoctionInfoAdapter(this,data,this)
            rvLoctionInfo.adapter = Adapter
        }

    }

    override fun onClickItem(position: Int) {
        TODO("Not yet implemented")
    }


}
