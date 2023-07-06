package com.mastercoding.sharedprefapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var name_textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        name_textView =findViewById(R.id.textViewName)
        val btn : Button = findViewById(R.id.btn)

        DisplaySavedName()

        btn.setOnClickListener(){
            val enteredText: String = editText.text.toString()
            SaveNameInSharedPref(enteredText)
        }
    }

    private fun SaveNameInSharedPref(enteredText: String) {

        // Opening the Shared Pref
        val sharedPreferences : SharedPreferences =
            getSharedPreferences(
                "UserName",
                MODE_PRIVATE
            )

        // Writing data to shared pref
       val editor: SharedPreferences.Editor =
           sharedPreferences.edit()

        editor.putString("name",enteredText)
        editor.commit()
    }

    // Reading Data from Shared Pref
    fun DisplaySavedName(){
       val  sharedPreferences : SharedPreferences =
           getSharedPreferences("UserName", MODE_PRIVATE)

       val  s1 : String? = sharedPreferences.getString(
           "name","")

        name_textView.setText(s1)
    }


}