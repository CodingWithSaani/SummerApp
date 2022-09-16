
package com.tutorials180.summerapp.Firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.WriteBatch
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tutorials180.summerapp.R
import java.lang.Exception

class Firestore : AppCompatActivity() {

    private var mFirestore = Firebase.firestore
    private lateinit var addDataBtn: Button

    private lateinit var firestoreProgressBar:ProgressBar
    private lateinit var addDocumentWithIdBtn:Button

    private lateinit var getDataWithIdBtn:Button
    private lateinit var documentDataTV:TextView

    private lateinit var getCollectionDataBtn:Button
    private lateinit var collectionDataTV:TextView

    private lateinit var mWriteBatch:WriteBatch
    private lateinit var batchBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firestore)

        connector()
    }

    private fun connector() {
        addDataBtn = findViewById(R.id.firstore_add_data_btn)
        firestoreProgressBar = findViewById(R.id.firestore_progressbar)

        addDocumentWithIdBtn = findViewById(R.id.firstore_add_data_with_id_btn)
        getDataWithIdBtn = findViewById(R.id.firstore_get_data_with_id_btn)

        documentDataTV = findViewById(R.id.data_tv_firestore)
        getCollectionDataBtn = findViewById(R.id.firstore_get_data_collection_btn)

        collectionDataTV = findViewById(R.id.collection_data_tv_firestore)
        mWriteBatch = mFirestore.batch()

        batchBtn = findViewById(R.id.firstore_batch_btn)
        addDataBtn.setOnClickListener {
            addSimpleDataToFirestore()
        }

        addDocumentWithIdBtn.setOnClickListener {
            addDocumentWithId()
        }

        getDataWithIdBtn.setOnClickListener {
            getDocumentWithId()
        }

        getCollectionDataBtn.setOnClickListener {
            getCollectionFromFirestore()
        }

        batchBtn.setOnClickListener {
            performBatch()
        }
    }

    private fun performBatch() {
        try
        {
            firestoreProgressBar.visibility =View.VISIBLE
            var doc1 = hashMapOf("name" to "Ali")
            var doc2 = hashMapOf("name" to "Ali")

            var doc1ID = mFirestore.collection("student_records").document()
            var doc2ID = mFirestore.collection("student_records").document("stu4")

            mWriteBatch.set(doc1ID,doc1)
            mWriteBatch.set(doc2ID,doc2)

            mWriteBatch.commit()
                .addOnSuccessListener { _:Void? ->
                    firestoreProgressBar.visibility =View.INVISIBLE
                    Toast.makeText(applicationContext, "Documents added", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener {
                    firestoreProgressBar.visibility =View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
                }

        }
        catch (ex:Exception)
        {
            firestoreProgressBar.visibility =View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getCollectionFromFirestore() {
        try
        {
            firestoreProgressBar.visibility =View.VISIBLE
            mFirestore.collection("student_records")
                .get()
                .addOnSuccessListener {
                    var allData = ""
                    for(singleDocument in it)
                    {
                        allData += singleDocument.getString("name")+ "\n"
                    }

                    collectionDataTV.text = allData
                    firestoreProgressBar.visibility =View.INVISIBLE
                }
                .addOnFailureListener {
                    firestoreProgressBar.visibility =View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
        catch (ex:Exception)
        {
            firestoreProgressBar.visibility =View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getDocumentWithId() {
        try
        {
            firestoreProgressBar.visibility =View.VISIBLE
            mFirestore.collection("student_records").document("stu1")
                .get()
                .addOnSuccessListener {
                    firestoreProgressBar.visibility =View.INVISIBLE
                    documentDataTV.text = "name: ${it.getString("name")}, rollNo:${it.getLong("roll_no")}"
                }
                .addOnFailureListener {
                    firestoreProgressBar.visibility =View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show();
                }
        }
        catch (ex:Exception)
        {
            firestoreProgressBar.visibility =View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun addDocumentWithId() {
        try
        {
            val dataForStudent = hashMapOf("name" to "Hamza", "rollno" to 23)
            firestoreProgressBar.visibility = View.VISIBLE

            addDocumentWithIdBtn.isEnabled = false
            mFirestore.collection("student_records").document("stu3")
                .set(dataForStudent)
                .addOnSuccessListener { _:Void? ->
                    firestoreProgressBar.visibility = View.INVISIBLE
                    addDocumentWithIdBtn.isEnabled = true

                    Toast.makeText(applicationContext, "Document added with key", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener {
                    firestoreProgressBar.visibility = View.INVISIBLE
                    addDocumentWithIdBtn.isEnabled = true

                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show();
                }
        }
        catch (ex:Exception)
        {
            firestoreProgressBar.visibility = View.INVISIBLE
            addDocumentWithIdBtn.isEnabled = true
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun addSimpleDataToFirestore() {
        try
        {
            var studentData = HashMap<String,Any>()
            studentData.set("name","Ali Raza")

            studentData.set("rollno", 22)
            firestoreProgressBar.visibility = View.VISIBLE

            addDataBtn.isEnabled = false
            mFirestore.collection("student_records")
                .add(studentData)
                .addOnSuccessListener {
                    firestoreProgressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "Data has added", Toast.LENGTH_SHORT).show();

                    addDataBtn.isEnabled = true
                }
                .addOnFailureListener {
                    firestoreProgressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show();

                    addDataBtn.isEnabled = true
                }
        }
        catch (exceptionObject:Exception)
        {
            firestoreProgressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "${exceptionObject.message}", Toast.LENGTH_SHORT).show();

            addDataBtn.isEnabled = true
        }
    }

}