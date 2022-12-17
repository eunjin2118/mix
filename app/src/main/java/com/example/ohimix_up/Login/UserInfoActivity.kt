package com.example.ohimix_up.Login

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ohimix_up.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserInfoActivity : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_login);

        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser == null) {
            Toast.makeText(this, "사용자 정보가 없습니다. (로그인 필요)",
                Toast.LENGTH_SHORT).show()
            finish()

        }
        // user 객체에 기본 제공하는 여러 정보 확인 가능 (uid는 해당 사용자를 위해서 자동 부여된 고유한 id임)
        findViewById<TextView>(R.id.user_info).text = """
            uid: ${currentUser?.uid}
            email: ${currentUser?.email}
            isEmailVerified: ${currentUser?.isEmailVerified}
            displayName: ${currentUser?.displayName}
            """.trimIndent()
        findViewById<Button>(R.id.logout_btn).setOnClickListener {
        // signOut 메서드 호출하여 로그아웃 처리 가능 (이후 auth.currentUser값은 null이 됨)
            auth.signOut()
            Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
