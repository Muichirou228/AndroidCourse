package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<TextView>(R.id.textView3).text = intent.getStringExtra("textViewText")
        findViewById<TextView>(R.id.textView4).text = intent.extras?.getParcelable<User>("classicalALESHA")!!.name
        findViewById<Button>(R.id.button).setOnClickListener {
            val returnIntent = Intent().putExtra("resultData", "Результат работы второго активити!\nВремя: ${System.currentTimeMillis()}")
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }

}