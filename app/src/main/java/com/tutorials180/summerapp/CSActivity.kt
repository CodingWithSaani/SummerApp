package com.tutorials180.summerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CSActivity : AppCompatActivity() {

    private lateinit var registerBtn: Button
    private lateinit var csStudentNameET:EditText

    private lateinit var csStudentRollNoET:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_csactivity)

        registerBtn = findViewById(R.id.cs_register_btn)
        csStudentNameET = findViewById(R.id.cs_student_name_et)

        csStudentRollNoET = findViewById(R.id.cs_student_roll_et)
        registerBtn.setOnClickListener {
            registerCSStudent()
        }
    }

    private fun registerCSStudent()
    {
        var studentName= csStudentNameET.text.toString()
        var studentRollNo = csStudentRollNoET.text.toString()

        var objIntent = Intent(CSActivity@this,RegisterActivity::class.java)
        objIntent.putExtra("name",studentName)

        objIntent.putExtra("roll",studentRollNo)
        startActivity(objIntent)
    }
}