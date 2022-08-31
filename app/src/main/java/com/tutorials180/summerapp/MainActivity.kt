package com.tutorials180.summerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var csBtn:Button = findViewById(R.id.cs_btn)

        var seBtn:Button = findViewById(R.id.se_btn)
        var adpBtn:Button = findViewById(R.id.adp_btn)

        csBtn.setOnClickListener {
            Toast.makeText(this,"CS Button is clicked",Toast.LENGTH_SHORT).show()

            startActivity(Intent(this,CSActivity::class.java))
        }

        seBtn.setOnClickListener {
            Toast.makeText(this,"SE Button is clicked",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,SEActivity::class.java))
        }

        adpBtn.setOnClickListener {
            Toast.makeText(this,"ADP Button is clicked",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,ADPActivity::class.java))
        }
     }

  }