package com.firstapp.lab5activity1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity2 : AppCompatActivity() {
    var data = ""
    var result = ArrayList<String>()
    var result1 = ArrayList<String>()
    lateinit var t1 : TextView
    lateinit var t2 : TextView
    lateinit var t3 : TextView
    var i = 0
    var j = 0
    lateinit var scanner: Scanner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val randomNumber = (0..4).random()
        when(randomNumber){
            0 ->{
                scanner = Scanner(resources.openRawResource(R.raw.madlib0))
            }
            1 ->{
                scanner = Scanner(resources.openRawResource(R.raw.madlib1))
            }
            2 ->{
                scanner = Scanner(resources.openRawResource(R.raw.madlib2))
             }
            3 ->{
                scanner = Scanner(resources.openRawResource(R.raw.madlib3))
            }
            4 ->{
                scanner = Scanner(resources.openRawResource(R.raw.madlib4))
            }
        }


        while(scanner.hasNext()){
            data+=scanner.nextLine()

        }
        Log.d("Data",data)
        var regex = """(\<(/?[^\>]+)\>)""".toRegex()
        val foundResults  = regex.findAll(data)
        for (findText in foundResults) {
            result.add(findText.value.toString())
        }
        j =  result.size
        t1 = findViewById(R.id.totalNumber)
        t2   = findViewById(R.id.TextToWrite)

        t1.text = j.toString()+"  Word Left"
        t2.text = "Please type a/an "+result[i].toString()
        t3= findViewById(R.id.editTextTextPersonName)


        Log.d("total array",result.toString())

    }
   fun GetStarted(view: View){

       data = data.replace(result[i].toString(),t3.text.toString())

       if(i == result.size-1){
            t1.text = "0 words remaining"
            start()
        }

      else {

          Log.d("array",result[i])
          ++i;
          --j;
           t2.text = "Please type a/an " + result[i].toString()
           t1.text = j.toString() + "  Word Left"
           t3.text = ""

       }

   }

    private fun start() {
        var string = Bundle()
        string.putString("data",data.toString())
        val intent = Intent(this,MainActivity3::class.java)
        intent.putExtras(string)
        startActivity(intent)
    }


}

