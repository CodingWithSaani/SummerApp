package com.tutorials180.summerapp.Adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.tutorials180.summerapp.R

class AdapterListViewActivity : AppCompatActivity() {

    private var daysNames = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    private lateinit var daysNamesList:ListView  //Declare

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_list_view)

        initializer()

        daysNamesList.adapter = ArrayAdapter(AdapterListViewActivity@this,android.R.layout.simple_list_item_1,daysNames)
    }

    private fun initializer()
    {
        daysNamesList = findViewById(R.id.days_names_list)
    }
}











