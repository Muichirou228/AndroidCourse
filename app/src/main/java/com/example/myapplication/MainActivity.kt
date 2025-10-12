package com.example.myapplication

import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.widget.TextView
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop
import com.google.android.material.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val greetingTextView: TextView = findViewById(R.id.textView)
        ObjectAnimator.ofFloat(greetingTextView, "alpha", 0f, 1f).apply {
            duration = 3000
            start()
        }
        val buttonComponent = findViewById<Button>(R.id.button)
        buttonComponent.setOnClickListener {
            it.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(300).start()
            }
        }

        val imageComponent = findViewById<ImageView>(R.id.imageView)
        ObjectAnimator.ofFloat(imageComponent, "rotation", 0f, 360f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE
            start()
        }
        val buttonNextComponent = findViewById<Button>(R.id.button3)
        buttonNextComponent.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}