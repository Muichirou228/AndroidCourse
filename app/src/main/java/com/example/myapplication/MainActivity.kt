package com.example.myapplication

import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.TextView 
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myThread = Thread {
            for (i in 1..5) {
                // Правильное использование TextView
                runOnUiThread {
                    findViewById<TextView>(R.id.TV).text =
                        findViewById<TextView>(R.id.TV).text.toString() + "!!!!"
                }
                Thread.sleep(1000L)
            }
        }
        myThread.start() // Не забудьте запустить поток!

        var radioGroupInfo = findViewById<RadioGroup>(R.id.radioGroup)
        var buttonCheck: Button = findViewById(R.id.checkButton)
        buttonCheck.setOnClickListener {
            val selectedId = radioGroupInfo.checkedRadioButtonId
            if (selectedId == R.id.radioButton) {
                Toast.makeText(this, "GOOD", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "BAD", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onButtonClick (view: View) {
        val textView = findViewById<TextView>(R.id.TV)
        textView.setText(textView.text.toString() + "666")
    }
}