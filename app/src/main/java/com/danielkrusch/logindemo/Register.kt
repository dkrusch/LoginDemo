package com.danielkrusch.logindemo

import android.content.Context //allows objects to get information about their current state
import android.content.Intent //operation to start activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log //adds log messages
import android.view.View //button object type
import android.widget.Button //defines views specifically as buttons
import android.widget.EditText //editable text field
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

        //declares objects for use in methods
        var username = findViewById<EditText>(R.id.txtUserReg) as EditText
        var password = findViewById<EditText>(R.id.txtPassReg) as EditText
        var email = findViewById<EditText>(R.id.txtEmailReg) as EditText
        var btnRegister = findViewById<View>(R.id.btnRegister) as Button

        //gets entered strings and stores them in preferences
        btnRegister.setOnClickListener {
            var preferences: SharedPreferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)
            var newUser = username.getText().toString()
            var newPassword = password.getText().toString()
            var newEmail = email.getText().toString()



            var editor: SharedPreferences.Editor = preferences.edit()

            //stores 3 new instances of sharedprefs. Both the user and password's keys are the same as the input.
            //so I use strings instead.
            editor.putString(newUser, newUser)
            editor.commit()
            editor.putString(newPassword, newPassword)
            editor.commit()
            editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail)
            editor.commit()

            val mainScreen = Intent(this@Register, MainActivity::class.java)
            startActivity(mainScreen)
        }
    }
}
