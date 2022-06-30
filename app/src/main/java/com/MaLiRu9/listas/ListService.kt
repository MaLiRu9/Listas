package com.MaLiRu9.listas

import android.content.Context
import android.util.Log
import java.io.File

class ListService(context: Context) {

    var context = context
    val fileName = "lists.txt"
    var list = mutableListOf<String>()
    val file = File(context.filesDir, fileName)

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