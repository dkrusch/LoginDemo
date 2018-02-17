package com.danielkrusch.logindemo

import android.content.Context //allows objects to get information about their current state
import android.content.Intent //operation to start activity
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View //button object type
import android.widget.Button //defines views specifically as buttons
import android.widget.EditText //editable text field
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameMain = findViewById<EditText>(R.id.txtFldUsername) as EditText
        val passowrdMain = findViewById<EditText>(R.id.txtFldPassword) as EditText
        val btnLoginMain = findViewById<View>(R.id.btnLog) as Button
        val btnRegisterMain = findViewById<View>(R.id.btnReg) as Button

        btnLog.setOnClickListener {
            val user = txtFldUsername.text.toString()
            val password = txtFldPassword.text.toString()
            val preferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)

            //String savedPassword = preferences.getString(password, "");
            //String savedUserName = preferences.getString(user, "");

            val userDetails = preferences.getString(user + password + "data", "No information on that user.")
            val editor = preferences.edit()
            editor.putString("display", userDetails)
            editor.commit()

            val displayScreen = Intent(this@MainActivity, DisplayScreen::class.java)
            startActivity(displayScreen)
        }


        btnReg.setOnClickListener {
            val registerScreen = Intent(this@MainActivity, Register::class.java)
            startActivity(registerScreen)
        }
    }


}
