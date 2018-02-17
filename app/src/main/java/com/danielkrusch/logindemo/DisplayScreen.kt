package com.danielkrusch.logindemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.display.*


class DisplayScreen : AppCompatActivity()
{

    //gets current preferences and textview and sets it to the current preferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display)

        val preferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)
        val display = preferences.getString("display", "")

        val displayInfo: TextView = txtUsername
        displayInfo.text = display

    }
}


