package com.example.ohimix_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView

        bnv_main.run {
            setOnNavigationItemReselectedListener {
                when(it.itemId){
                    R.id.item_fragment1 -> {
                        val Home = HomeFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container,Home).commit()
                    }
                    R.id.item_fragment2 -> {
                        val  Quiz = QuizFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, Quiz
                        ).commit()
                    }
                    R.id.item_fragment3 -> {
                        val Community = CommunityFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, Community).commit()
                    }
                    R.id.item_fragment4 -> {
                        val User = UserFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.fl_container, User).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.item_fragment1
        }



    }
}