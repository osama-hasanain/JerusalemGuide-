package com.example.jerusalemiugtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.jerusalemiugtwo.fragment.HomeFragment
import com.example.jerusalemiugtwo.fragment.InformationFragment
import com.example.jerusalemiugtwo.fragment.LoctionFragment
import com.example.jerusalemiugtwo.fragment.MultimediaFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ID_HOME = 1
            private const val ID_INFORMATION = 2
        private const val ID_LOCTION = 3
        private const val ID_MULTIMUDIA = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = bottomNavigation
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_info))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_location))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.ic_music))

        bottomNavigation.setOnShowListener {
            val name: Fragment = when (it.id) {
                ID_HOME ->  HomeFragment()
                ID_INFORMATION ->  InformationFragment()
                ID_LOCTION ->  LoctionFragment()
                ID_MULTIMUDIA ->  MultimediaFragment()
                else -> HomeFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.mainContainer,name).commit()
        }

        bottomNavigation.show(ID_HOME)

        bottomNavigation.setOnClickMenuListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_INFORMATION -> "INFORMATION"
                ID_LOCTION -> "LOCTION"
                ID_MULTIMUDIA->"MULTIMUDIA"
                else -> ""
            }
        }


    }
}
