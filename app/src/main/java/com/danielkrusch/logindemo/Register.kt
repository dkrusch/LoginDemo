package com.danielkrusch.logindemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.register.*
import java.util.prefs.Preferences

/**
 * Created by Daniel on 2/15/2018.
 */

class Register : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        var username = findViewById<EditText>(R.id.txtUserReg) as EditText
        var password = findViewById<EditText>(R.id.txtPassReg) as EditText
        var email = findViewById<EditText>(R.id.txtEmailReg) as EditText
        var btnRegister = findViewById<View>(R.id.btnRegister) as Button

        btnRegister.setOnClickListener {
            var preferences: SharedPreferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)
            var newUser = username.getText().toString()
            var newPassword = password.getText().toString()
            var newEmail = email.getText().toString()
            val mainScreen = Intent(this@Register, MainActivity::class.java)


            var editor: SharedPreferences.Editor = preferences.edit()

            //stores 3 new instances of sharedprefs. Both the user and password's keys are the same as the input.
            //Must be done this way because sharedprefs is stupid and inefficient. You cannot store Arrays easily
            //so I use strings instead.
            editor.putString(newUser,newUser)
            editor.commit()
            editor.putString(newPassword, newPassword)
            editor.commit()
            editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail)
            editor.commit()
            Log.e("s","omething is happening")

            startActivity(mainScreen)
        }
    }
}
