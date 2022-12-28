package com.firstapp.lab5activity2

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.collections.ArrayList


class ListFragment : Fragment() {
    lateinit var output :TextView
    var arrayList = ArrayList<String>()

    lateinit var adapter :ArrayAdapter<String>
    lateinit var scan: Scanner
    override fun onCreate(savedInstanceState: Bundle?) {
        scan = Scanner(activity?.openFileInput("out.txt"))
        while (scan.hasNextLine()) {
            val line: String = scan.nextLine()
            arrayList.add(line)
        }
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_list, container, false)
        val text : ListView = view.findViewById(R.id.listview)
//        output = view.findViewById(R.id.te)
        adapter = ArrayAdapter(view.context,android.R.layout.simple_list_item_1,arrayList)
        text.adapter = adapter
        return view
    }
}
