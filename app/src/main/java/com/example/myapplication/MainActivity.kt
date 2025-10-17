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

data class User(val name: String, val age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User = User(parcel)
        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
}

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
        var resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Log.d("intent", "MESSAGE!!!")
                    Toast.makeText(this, result.data?.getStringExtra("resultData"), Toast.LENGTH_LONG).show()
            }
        }
        val buttonNext = findViewById<Button>(R.id.nextButton)
        val intentElement = Intent(this, MainActivity2::class.java)
        buttonNext.setOnClickListener {
            val alesha = User("ALESHA", 12);
            intentElement.putExtra("textViewText", "RESOURCE FROM 1 ACTIVITY")
            intentElement.putExtra("classicalALESHA", alesha);
            resultLauncher.launch(intentElement)
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, "https://chat.deepseek.com/a/chat/s/965e8479-a45d-4b9a-9262-585a7f9b2f6e".toUri()))
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }
}