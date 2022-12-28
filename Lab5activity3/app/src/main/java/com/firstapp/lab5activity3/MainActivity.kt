package com.firstapp.lab5activity3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    lateinit var listveiw :ListView
    lateinit var textView: EditText
    lateinit var adapter: UserAdapter

    data class User( val name : String, val phone : String)

    var  arrayList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listveiw = findViewById(R.id.listview)
        textView = findViewById(R.id.editTextTextPersonName)

    }

    fun addData(view:View){
        if(!(textView.text.isNullOrEmpty())) {
                   var name  = textView.text.toString()
                    textView.text = null
                    arrayList.add(User(name,"0230303030"))
                    adapter = UserAdapter(this, R.layout.row, arrayList as List<User?>)
                    listveiw.adapter = adapter
        }
        else{
            Toast.makeText(this,"please write something",Toast.LENGTH_SHORT ).show()
        }

    }

    class UserAdapter(context: Context, resource: Int, objects: List<User?>) :
        ArrayAdapter<User>(context, resource, objects){
        val cont = context
        val res = resource
        val data = objects

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

          val itemView = LayoutInflater.from(cont).inflate(res, parent, false)

            var name = itemView.findViewById<TextView>(R.id.name)
            name.text = data[position]?.name

            var phone = itemView.findViewById<TextView>(R.id.phone)
            phone.text = data[position]?.phone

            return itemView
        }
    }








}
