package com.firstapp.lab5activity2

import android.content.ContentValues
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var db = openOrCreateDatabase("Student2", MODE_PRIVATE,null)
//        val string = "CREATE TABLE  IF NOT EXISTS Login(ID INTEGER ,UserName TEXT,Password TEXT)"
//        db.execSQL(string)
//        val content = ContentValues()
//        content.put("ID",1)
//        content.put("UserName",",mujtaba")
//        content.put("Password","123")
//
//        content.put("ID",2)
//        content.put("UserName",",aniket")
//        content.put("Password","123")
//
//
//
//        db.insert("Login",null,content)
//        val str = "DELETE FROM Login WHERE ID=1"
//        db.execSQL(str)
//
//        val query = "SELECT UserName FROM Login"
//        val curse = db.rawQuery(query,null)
//        curse.moveToFirst()
//        do{
//            Log.d("Name",curse.getString(0))
//        }while (curse.moveToNext())
//
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val manager : FragmentManager = supportFragmentManager
        val transaction : FragmentTransaction = manager.beginTransaction()
        transaction.replace(R.id.framgent,AddFragment())
        transaction.commit()
        return super.onOptionsItemSelected(item)

    }

}