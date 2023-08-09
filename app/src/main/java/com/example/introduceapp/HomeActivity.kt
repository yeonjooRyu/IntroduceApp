package com.example.introduceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.introduceapp.R.id.btn_login

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val strData = intent.getStringExtra("dataFromSignInActivity")
        val editText = findViewById<EditText>(R.id.editText_blank)
        editText.setText("아이디: $strData")

        val btn = findViewById<Button>(R.id.btn_end)
        btn.setOnClickListener{
            finish()
        }
    }
}