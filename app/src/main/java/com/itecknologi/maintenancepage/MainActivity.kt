package com.itecknologi.maintenancepage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    //    private  lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList: ArrayList<Model>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<Model>()

        val adapter = CustomAdapter(data)

        recyclerview.adapter = adapter

        //addButton logic
        val addButton = findViewById<ImageView>(R.id.addSign)
        addButton.setOnClickListener {
            showDialog()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }


    private fun showDialog() {
        // Inflate the custom layout/view for the dialog
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_alert_box, null)
        val cancelButton =
            dialogView.findViewById<com.google.android.material.button.MaterialButton>(R.id.button1)
        val saveButton =
            dialogView.findViewById<com.google.android.material.button.MaterialButton>(R.id.button2)

        // Create the AlertDialog
        val dialog = AlertDialog.Builder(this)
            .setTitle("Custom Dialog")
            .setView(dialogView)
            .create()

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        saveButton.setOnClickListener {

        }

        dialog.show()
    }


}
