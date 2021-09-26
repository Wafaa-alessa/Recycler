package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var clMain: ConstraintLayout
    private lateinit var Field: EditText
    private lateinit var fieldButton: Button
    private lateinit var text: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clMain = findViewById(R.id.clMain)
        text = ArrayList()

        recyclerView2.adapter = MessageAdapter(this, text)
        recyclerView2.layoutManager = LinearLayoutManager(this)

        Field = findViewById(R.id.textView2)
        fieldButton = findViewById(R.id.button)

        fieldButton.setOnClickListener { addMessage() }
    }

    private fun addMessage(){
        val msg = Field.text.toString()
        if(msg.isNotEmpty()){
            text.add(msg)
            Field.text.clear()
            Field.clearFocus()
        }else{
            Snackbar.make(clMain, "Please enter your name", Snackbar.LENGTH_LONG).show()
        }
    }
}