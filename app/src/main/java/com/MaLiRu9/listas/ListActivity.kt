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

        val newItem = findViewById<Button>(R.id.newButton)
        newItem.setOnClickListener {
            addNewitem()
        }
    }

    private fun addNewitem() {
        val randomText: String = Date().toString()
        list.add(randomText)

        val textView = TextView(this)
        textView.text = randomText

        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        listLayout.addView(textView)
    }
}