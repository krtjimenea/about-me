package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener{addNickname(it)}
        findViewById<TextView>(R.id.textView).setOnClickListener {
            updateNickname(it)
        }


    }

    /* Adding a click handler */

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.editText)
        val nicknameTextView: TextView = findViewById<TextView>(R.id.textView)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE

        nicknameTextView.visibility = View.VISIBLE

            //Hide Keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickname(view: View){

        val editText = findViewById<EditText>(R.id.editText)
        val doneButton = findViewById<Button>(R.id.done)

        editText.visibility = View.VISIBLE
        doneButton.visibility= View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
// Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)




    }

}
