package com.example.introduceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class SignInActivity : AppCompatActivity() {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = findViewById<EditText>(R.id.editTextId)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btn2 = findViewById<Button>(R.id.btn_signup)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val user_id = it.data?.getStringExtra("id") ?:""
                val user_pw = it.data?.getStringExtra("password") ?:""
                id.setText(user_id)
                password.setText(user_pw)
            }
        }

        //로그인 버튼 클릭시 HomeActivity화면으로 이동
        val btn1 = findViewById<Button>(R.id.btn_login)

        btn1.setOnClickListener {
            val inputId = id.text.toString()
            val inputPassword = password.text.toString()

            if (inputId.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val edit_text = findViewById<EditText>(R.id.editTextId)
                val strData = edit_text.text.toString()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("dataFromSignInActivity", strData)
                startActivity(intent)
            }
        }


        //회원가입 버튼 클릭 시 SingUpActivity 화면으로 이동
        btn2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }


}
