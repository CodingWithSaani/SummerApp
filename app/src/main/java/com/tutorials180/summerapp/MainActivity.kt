package com.tutorials180.summerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.tutorials180.summerapp.Adapters.AdapterListViewActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapterListViewActivityBtn:Button

    private lateinit var csBtn:Button

    private lateinit var seBtn:Button
    private lateinit var adpBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connector()
    }

    private fun connector()
    {
        adapterListViewActivityBtn = findViewById(R.id.adapter_list_view_activity_btn)
        adapterListViewActivityBtn.setOnClickListener {
            startActivity(Intent(MainActivity@this,AdapterListViewActivity::class.java))
        }

        csBtn= findViewById(R.id.cs_btn)

        seBtn= findViewById(R.id.se_btn)
        adpBtn= findViewById(R.id.adp_btn)

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