
package com.tutorials180.summerapp.Firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tutorials180.summerapp.R

class Firestore : AppCompatActivity() {

    private var mFirestore = Firebase.firestore
    private lateinit var addDataBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firestore)

        connector()
    }

    private fun connector()
    {
        addDataBtn = findViewById(R.id.firstore_add_data_btn)
        addDataBtn.setOnClickListener {
            addSimpleData()
        }
    }

    private fun addSimpleData() {
        var studentRecord = hashMapOf("name" to "Ali",
            "rollNo" to 123)

        mFirestore.collection("student_records").document("stu3")
            .set(studentRecord)
            .addOnSuccessListener {
                Toast.makeText(applicationContext, "Data Successfully added", Toast.LENGTH_SHORT).show();
            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Fails to add data", Toast.LENGTH_SHORT).show();
            }
    }
}