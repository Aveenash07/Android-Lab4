package com.firstapp.lab5activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var t1 : TextView = findViewById(R.id.textView)


        val bundle = intent.extras
        if (bundle != null){
            t1.text = "${bundle.getString("data")}"
        }

    }

}