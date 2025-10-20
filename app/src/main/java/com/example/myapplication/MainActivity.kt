package com.example.myapplication

import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.animation.Animator
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.content.pm.LabeledIntent
import android.net.Uri
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop
import androidx.versionedparcelable.ParcelField
import com.google.android.material.animation.AnimationUtils
import java.io.Serializable


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
        //1
        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/audios536343293?section=all")));
        }
        //2
        findViewById<Button>(R.id.button4).setOnClickListener {
            val videoId = "dQw4w9WgXcQ"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$videoId"))
            startActivity(intent)
        }
        //3
        findViewById<Button>(R.id.button5).setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            startActivity(intent)
        }
        //4
        findViewById<Button>(R.id.button6).setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            val chooser = Intent.createChooser(intent, "Выберите приложение для открытия фото")
            startActivity(chooser)
        }
        //5
        findViewById<Button>(R.id.button7).setOnClickListener {
            val phoneNumber = "+79161234567"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }
        //6
        findViewById<Button>(R.id.button8).setOnClickListener {
            val intent = Intent(Intent.ACTION_SET_WALLPAPER)
            startActivity(Intent.createChooser(intent, "Выберите обои"))
        }
        fun logIntentInfo(name: String, intent: Intent) {
            Log.d("INTENT", "🔹 $name")
            Log.d("INTENT", "   Action: ${intent.action}")
            Log.d("INTENT", "   Data: ${intent.data ?: "null"}")
            Log.d("INTENT", "   Type: ${intent.type ?: "null"}")

            val categories = intent.categories?.joinToString() ?: "null"
            Log.d("INTENT", "   Categories: $categories")

            val packages = packageManager.queryIntentActivities(intent, 0)
            val appNames = packages.joinToString { it.loadLabel(packageManager).toString() }
            Log.d("INTENT", "   Доступные приложения: $appNames")
            Log.d("INTENT", "─".repeat(40))
        }
        //7
        findViewById<Button>(R.id.button9).setOnClickListener {
            Log.d("INTENT", "═".repeat(50))
            Log.d("INTENT", "📱 СПИСОК INTENT ДЕЙСТВИЙ")
            Log.d("INTENT", "═".repeat(50))

            // 1. ACTION_VIEW - Веб
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            logIntentInfo("ACTION_VIEW - Веб-страница", webIntent)

            // 2. ACTION_VIEW - Телефон
            val phoneIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:+79161234567"))
            logIntentInfo("ACTION_VIEW - Телефон", phoneIntent)

            // 3. ACTION_VIEW - Карты
            val mapsIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.7558,37.6173"))
            logIntentInfo("ACTION_VIEW - Карты", mapsIntent)

            // 4. ACTION_VIEW - Email
            val emailIntent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:test@example.com"))
            logIntentInfo("ACTION_VIEW - Email", emailIntent)

            // 5. ACTION_SEND - Текст
            val sendTextIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Привет!")
            }
            logIntentInfo("ACTION_SEND - Текст", sendTextIntent)

            // 6. ACTION_GET_CONTENT - Фото
            val getContentIntent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            logIntentInfo("ACTION_GET_CONTENT - Фото", getContentIntent)

            // 7. ACTION_DIAL - Набор номера
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+79161234567"))
            logIntentInfo("ACTION_DIAL - Набор номера", dialIntent)

            Log.d("INTENT", "═".repeat(50))
            Toast.makeText(this, "Информация выведена в Logcat (INTENT)", Toast.LENGTH_SHORT).show()
        }
        }
    }

