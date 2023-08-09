package com.example.introduceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //로그인 버튼 클릭시 HomeActivity화면으로 이동
        val btn1 = findViewById<Button>(R.id.btn_login)

        val editId = findViewById<EditText>(R.id.editTextId)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)

        btn1.setOnClickListener {
            val inputId = editId.text.toString()
            val inputPassword = editPassword.text.toString()

        if(inputId.isEmpty() || inputPassword.isEmpty()){
            Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            val edit_text = findViewById<EditText>(R.id.editTextId)
            val strData = edit_text.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("dataFromSignInActivity", strData)
            startActivity(intent)
         }
        }


        //회원가입 버튼 클릭 시 SingUpActivity 화면으로 이동
        val btn2 = findViewById<Button>(R.id.btn_signup)

        btn2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }



    }
}