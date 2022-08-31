package com.tutorials180.summerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    private lateinit var studentNameTV:TextView
    private lateinit var studentRollNoTV:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        studentNameTV = findViewById(R.id.reg_name_tv)
        studentRollNoTV = findViewById(R.id.reg_roll_tv)

        var studentName = intent.getStringExtra("name")
        var studentRoll = intent.getStringExtra("roll")

        studentNameTV.text = "Name is:${studentName}"
        studentRollNoTV.text = "Roll no is:${studentRoll}"


    }
}