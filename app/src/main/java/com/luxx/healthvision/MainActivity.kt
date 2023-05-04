package com.luxx.healthvision

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var requestList: ArrayList<requestData>
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageRecyc = findViewById<RecyclerView>(R.id.imageRecyc)
        val addBtn = findViewById<FloatingActionButton>(R.id.addBtn)

        imageRecyc.layoutManager = LinearLayoutManager(this)
        requestList = arrayListOf()

        addBtn.setOnClickListener {
            val intent = Intent(this,addMedicine::class.java)
            startActivity(intent)
        }

        val requestAdapter = requestAdapter(requestList,this)
/*
        requestAdapter.onItemClick={
            Log.d("s","clickekddddddddddd")
            intent.putExtra("request",it)
            startActivity(intent)
        }*/

/*
        databaseReference = FirebaseDatabase.getInstance().getReference("request")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (dataSnapShot in snapshot.children){
                        val request = dataSnapShot.getValue(requestData::class.java)
                        requestList.add(request!!)
                    }
                    imageRecyc.adapter = requestAdapter

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })*/

    }
}