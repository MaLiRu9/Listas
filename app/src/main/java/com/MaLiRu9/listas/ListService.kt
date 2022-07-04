package com.MaLiRu9.listas

import android.content.Context
import android.util.Log
import org.json.JSONArray
import java.io.File
import java.io.IOException

class ListService(context: Context) {

    var context = context
    val fileName = "lists.txt"
    var list = mutableListOf<String>()
    val file = File(context.filesDir, fileName)

    var json = JSONArray()

    init {
        try {
            json = JSONArray(context.assets.open("example.json").bufferedReader().use { it.readText() })
            Log.d("Debug", "Example JSON" + json)
        } catch (ioException: IOException) {
            Log.d("Error", ioException.toString())
        }
    }

    fun getList():JSONArray{
        return json
    }

    //Get data from local file lists.txt
    fun getListFromFile():MutableList<String> {
        if (!file.exists()){
            file.createNewFile()
        }

        list = mutableListOf<String>()
        file.useLines {
            list.add(it.toString())
        }
        Log.d("Listas", "This is the filesDir: " + context.filesDir)
        return list
    }

    fun addItemToList(item: String) {
        list.add(item)
        file.printWriter().use {
            out -> list.forEach {
                out.println(it)
            }
        }
    }

}