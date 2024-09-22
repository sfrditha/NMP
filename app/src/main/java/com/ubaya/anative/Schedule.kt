package com.ubaya.anative

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.anative.databinding.ActivityMainBinding
import com.ubaya.anative.databinding.ActivityScheduleBinding

class Schedule : AppCompatActivity() {
    private lateinit var binding : ActivityScheduleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        enableEdgeToEdge()
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = arrayOf("Schedule 1", "Schedule 2", "Schedule 3")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, name
        )
        binding.scheduleListView.adapter = arrayAdapter


        binding.scheduleListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Clicked: ${name[position]}", Toast.LENGTH_SHORT).show()
        }

//        binding = ActivityScheduleBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val listview = findViewById<ListView>(R.id.scheduleListView)
//        val name = arrayOf("Schedule 1", "Schedule 2", "Schedule 3")
//
//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this,
//            android.R.layout.simple_list_item_1, name)
//        listview.adapter = arrayAdapter
//
//        binding.scheduleListView.setOnClickListener {
//            Toast.makeText(this,"Tess",Toast.LENGTH_SHORT).show()
//        }

//       listview.setOnClickListener { adapterView, view, i, l ->
//           Toast.makeText(this,"Tess",Toast.LENGTH_SHORT).show()
//       }



//        setContentView(R.layout.activity_schedule)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}