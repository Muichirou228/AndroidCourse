package com.example.myapplication

import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            val mainLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                gravity = Gravity.CENTER
            }
            val TV1 = TextView(this).apply{
                text = "Hello Programmed-View!"
                textSize = 18f
                setTextColor(getColor(R.color.black))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply{
                    setMargins(0,30,0,0)
                }
            }
            mainLayout.addView(TV1)
            for (i in 1..10) {
                var TV2 = TextView(this).apply{
                    text = "$i"
                    textSize = 18f
                    setTextColor(getColor(R.color.black))
                    gravity = Gravity.CENTER
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply{
                        setMargins(0,10,0,0)
                    }
                }
                mainLayout.addView(TV2)
            }
            val buttons = arrayOf(
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
            )
            val calculatorLayout = GridLayout(this).apply {
                columnCount = 4
                rowCount = 4
                layoutParams = LinearLayout.LayoutParams(
                    WRAP_CONTENT,
                    WRAP_CONTENT
                ).apply { //кратцце apply что такое
                    gravity = Gravity.CENTER  // выравнивание по центру
                    setMargins(0, 50, 0, 0)   // отступ сверху
                }
            }

            for (i in 0 until 4) { // строки
                for (j in 0 until 4) { // столбцы
                    val index = i * 4 + j
                    val button = Button(this).apply {
                        text = buttons[index]
                        layoutParams = GridLayout.LayoutParams().apply { // почему тут LayoutParams ()???
                            rowSpec = GridLayout.spec(i)
                            columnSpec = GridLayout.spec(j)
                        }
                    }
                    calculatorLayout.addView(button)
                }
            }
            mainLayout.addView(calculatorLayout)
            setContentView(mainLayout) // почему setContentView
            insets
        }

}
}