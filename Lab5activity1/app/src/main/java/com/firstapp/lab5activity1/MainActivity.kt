package com.firstapp.lab5activity1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.NonCancellable.start
import java.util.*

class MainActivity : AppCompatActivity() {
    var data = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun nextScreen(view: View){

        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)

    }





}