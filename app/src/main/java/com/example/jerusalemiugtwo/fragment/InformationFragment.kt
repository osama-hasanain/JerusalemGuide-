package com.example.jerusalemiugtwo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jerusalemiugtwo.R
import com.example.jerusalemiugtwo.RecycleViewInfo.CardInfo
import com.example.jerusalemiugtwo.RecycleViewInfo.CardInfoAdapter
import com.example.jerusalemiugtwo.RecycleViewLoction.CardLoction
import com.example.jerusalemiugtwo.RecycleViewLoction.CardLoctionAdapter
import kotlinx.android.synthetic.main.fragment_information.view.*
import kotlinx.android.synthetic.main.fragment_loction.view.*

class InformationFragment : Fragment(),CardInfoAdapter.onClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_information, container, false)

        val data = mutableListOf<CardInfo>()
        data.add(CardInfo(R.drawable.aqsa_6,"فضائل بيت المقدس وما حوله من السنة"))
        data.add(CardInfo(R.drawable.aqsa_5,"مكانة القدس في الاسلام"))
        data.add(CardInfo(R.drawable.aqsa_4,"جوامع ومصليات المسجد الاقصى"))
        data.add(CardInfo(R.drawable.aqsa_3,"أروقة المسجد الأقصى المبارك"))
        data.add(CardInfo(R.drawable.aqsa_2,"قصة المسجد الاقصى عبر العصور"))
        data.add(CardInfo(R.drawable.aqsa_1,"أجر الصلاة في المسجد الاقصى"))
        data.add(CardInfo(R.drawable.aqsa_7,"تاريخ المسجد الاقصى المبارك"))



        root.rvInformation.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,true)
        root.rvInformation.setHasFixedSize(true)

        val Adapter = CardInfoAdapter(activity!!,data,this)
        root.rvInformation.adapter=Adapter



        return root
    }

    override fun onClickItem(position: Int) {
        //Toast.makeText(context,"Welcome to App",Toast.LENGTH_SHORT).show()
    }


}

/*
 data.add(CardInfo("فضائل بيت المقدس وما حوله في القرآن الكريم"))
        data.add(CardInfo("فضائل بيت المقدس وما حوله من السنة"))
        data.add(CardInfo("مكانة القدسة في الاسلام"))
        data.add(CardInfo("جوامع ومصليات المسجد الاقصى"))
        data.add(CardInfo("أروقة المسجد الأقصى المبارك"))
        data.add(CardInfo("قصة المسجد الاقصى عبر العصور"))
        data.add(CardInfo("أجر الصلاة في المسجد الاقصى"))
        data.add(CardInfo("قدسية القدس والمسجد الاقصى وشبهات اليهود"))
        data.add(CardInfo("٢. عهد اليبوسين وبني إسرائيل"))
        data.add(CardInfo("٣. العهد الروماني"))
        data.add(CardInfo("٤. القدس خلال الحكم البيزنطي"))
        data.add(CardInfo("٥. المسجد الاقصى في عهد النبي محمد صلى الله عليه وسلم"))
        data.add(CardInfo("٦.فتح بيت المقدس على يدي عمر بن الخطاب ـ رضى الله عنه"))
        data.add(CardInfo("٧. المسجد الاقصى في العهد الاموي"))
        data.add(CardInfo("٨. المسجد الاقصى في العهد العباسي ١٣٢هـ - ٧٥٠م"))
 */

/*
       data.add(CardInfo(1,"٨. المسجد الاقصى في العهد العباسي ١٣٢هـ - ٧٥٠م"))
        data.add(CardInfo(2,"٧. المسجد الاقصى في العهد الاموي"))
        data.add(CardInfo(3,"٦.فتح بيت المقدس على يدي عمر بن الخطاب ـ رضى الله عنه"))
        data.add(CardInfo(4,"٥. المسجد الاقصى في عهد النبي محمد صلى الله عليه وسلم"))
        data.add(CardInfo(5,"٤. القدس خلال الحكم البيزنطي"))
        data.add(CardInfo(6,"٣. العهد الروماني"))
        data.add(CardInfo(7,"٢. عهد اليبوسين وبني إسرائيل"))
        data.add(CardInfo(8,"قدسية القدس والمسجد الاقصى وشبهات اليهود"))
        data.add(CardInfo(9,"أجر الصلاة في المسجد الاقصى"))
        data.add(CardInfo(10,"قصة المسجد الاقصى عبر العصور"))
        data.add(CardInfo(11,"أروقة المسجد الأقصى المبارك"))
        data.add(CardInfo(12,"جوامع ومصليات المسجد الاقصى"))
        data.add(CardInfo(13,"مكانة القدسة في الاسلام"))
        data.add(CardInfo(14,"فضائل بيت المقدس وما حوله من السنة"))
        data.add(CardInfo(15,"فضائل بيت المقدس وما حوله في القرآن الكريم"))


 */