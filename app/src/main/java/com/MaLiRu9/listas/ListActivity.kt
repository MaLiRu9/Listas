package com.MaLiRu9.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.jocnunez.listas.R
import java.util.*

class ListActivity : AppCompatActivity() {
    var list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        Log.d("Debug", "List activity open")

        val listService = ListService(this)
        list = listService.getListFromFile()
        list.forEach {
            addItemToLayout(it)
        }

        val newItem = findViewById<Button>(R.id.newButton)
        newItem.setOnClickListener {
            addNewitem(listService)
        }
    }

    private fun addNewitem(service: ListService) {
        val randomText: String = Date().toString()
        service.addItemToList(randomText)
        addItemToLayout(randomText)
    }

    private fun addItemToLayout(text: String) {
        val textView = TextView(this)
        textView.text = text

        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        listLayout.addView(textView)
    }
}