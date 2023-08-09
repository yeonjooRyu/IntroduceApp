package com.example.introduceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn = findViewById<Button>(R.id.btn_singup)

        val editName = findViewById<EditText>(R.id.editName)
        val editId = findViewById<EditText>(R.id.editId)
        val editPassword = findViewById<EditText>(R.id.editPassword)

        btn.setOnClickListener{
            val inputName = editName.text.toString()
            val inputId = editId.text.toString()
            val inputPassword = editPassword.text.toString()

            if(inputName.isEmpty() || inputId.isEmpty() || inputPassword.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else{
                finish()
            }

        }
    }
}