package com.example.ohimix_up.Login

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ohimix_up.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class SignUpActivity : AppCompatActivity() {
    // 인증, 데이터베이스 객체 저장
    private val auth = Firebase.auth
    private val database = Firebase.database(Config.DATABASE_URL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.inputPW)
//        val passwordCheckEditText = findViewById<EditText>(R.id.password_check)
        val nicknameEditText = findViewById<EditText>(R.id.nickname)
        findViewById<Button>(R.id.signUpBtn).setOnClickListener {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
//            val passwordCheckEditText = passwordCheckEditText.text.toString()
        val nickname = nicknameEditText.text.toString()
        val profile = ""
            // createUserWithEmailAndPassword 메서드 호출하여 생성할 계정 정보(이메일, 패스워드) 전달
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { // 해당 이메일, 패스워드를 이용하는 계정 생성 완료
                    if(it.isSuccessful) {
                        // 계정 생성 성공 이후 유저 정보에 접근 가능
                        val user = auth.currentUser!!
                        Log.d("mytag", user.toString())

                        // 데이터베이스에다가도 유저 정보 저장
                        // (이 과정은 필수는 아니지만, 보통 유저와 관련된 다른 정보들을 입력받는 경우가 많으므로,
                        //데이터베이스에 따로 사용자 정보를 저장하는 것이 일반적임)
                        database.getReference("users")
                            // "/users/{uid} 경로에 계정 정보 생성"
                            .child(user.uid)
                            // 이메일과 별명 저장
                            // 상태메세지, 프로필 사진 저장해야함.
                            .setValue(mapOf("email" to email, "nickname" to
                                    nickname, "profile" to profile))
                            .addOnCompleteListener {
                                // 데이터베이스에 계정 정보 등록 완료
                                if(it.isSuccessful) {
// 등록한 이메일 주소로 인증 관련 이메일 보내기
                                    user.sendEmailVerification()
                                    Toast.makeText(SignUpActivity@this, "계정 생성 완료 (가입한 이메일의 인증 메일을 확인해주세요.)", Toast.LENGTH_LONG).show()
                                    finish()
                                } else {
                                  // 예외가 발생한 경우 전달받은 Task 객체(it)의 exception 속성을 통해 예외 객체 참조 가능, 여기서는 모든 예외를 한 메서드에서 처리하도록 구현함
                                    userRegisterFailed(it.exception)
                                }
                            }.addOnFailureListener {
                                userRegisterFailed(it)
                            }
                    } else {
                        userRegisterFailed(it.exception)
                    }

                }.addOnFailureListener {
                    userRegisterFailed(it)
                }
        }
        findViewById<Button>(R.id.cancel).setOnClickListener {
            finish()
        }
    }

    fun userRegisterFailed(e: Exception?) {
        val message = if(e == null) "계정 생성 실패" else "${e.message}"
        Log.d("mytag", "계정 생성 실패 ${message}")
        Toast.makeText(this, "${message}", Toast.LENGTH_SHORT).show()
    }
}

