package com.firstapp.lab5activity2

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.io.*
import java.util.*
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

import java.io.FileWriter


class AddFragment : Fragment(){

    lateinit var output:FileWriter

    override fun onCreate(savedInstanceState: Bundle?) {
//
//        output = PrintStream(activity?.openFileOutput("out.txt", MODE_PRIVATE))
        output = FileWriter("${activity?.filesDir}/out.txt",true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        var view = inflater.inflate(R.layout.fragment_add, container, false)

        var btn : Button = view.findViewById(R.id.buttonSave)
        btn.setOnClickListener {
            var editTextInput : EditText = view.findViewById(R.id.editTextTextPersonName)
            var fragment = ListFragment()
            output.write(editTextInput.text.toString())
            output.appendLine()
            output.close()
            val manager : FragmentManager = (activity as AppCompatActivity).supportFragmentManager
            val transaction : FragmentTransaction = manager.beginTransaction()
            transaction.replace(R.id.framgent,fragment)
            transaction.commit()
        }

        return view
    }



}

