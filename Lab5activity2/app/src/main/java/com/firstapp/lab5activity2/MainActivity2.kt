package com.firstapp.lab5activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val sharedPreferences = getSharedPreferences("dummy", MODE_PRIVATE)
        val id:TextView = findViewById(R.id.textView2)
        id.text = "welcome "+sharedPreferences.getString("name","notexists")
    }
}


