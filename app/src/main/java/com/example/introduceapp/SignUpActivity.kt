package com.example.introduceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    private lateinit var inputName : EditText
    private lateinit var inputId : EditText
    private lateinit var inputPassword : EditText
    private lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        inputName = findViewById(R.id.editName)
        inputId = findViewById(R.id.signupId)
        inputPassword = findViewById(R.id.signupPassword)
        btn = findViewById(R.id.btn_singup)


        btn.setOnClickListener{
            if(inputName.text.isEmpty() || inputId.text.isEmpty() || inputPassword.text.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else{
                intent.putExtra("id",inputId.text.toString())
                intent.putExtra("password",inputPassword.text.toString())
                setResult(RESULT_OK,intent)
                finish()
            }

        }
    }
}