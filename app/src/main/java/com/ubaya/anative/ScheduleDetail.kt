package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.anative.databinding.ActivityScheduleDetailBinding

class ScheduleDetail : AppCompatActivity() {
    private lateinit var binding : ActivityScheduleDetailBinding;
    var klik = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityScheduleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNotifyMe.setOnClickListener(){
            if(klik==0){
                klik=1
                Toast.makeText(this,"Notif berhasil ditambahkan",Toast.LENGTH_SHORT).show();
            }
            else if(klik==1){
                Toast.makeText(this,"Notif sudah ditambahkan",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Notif tidak berhasil ditambahkan",Toast.LENGTH_SHORT).show();
            }
        }

//        setContentView(R.layout.activity_schedule_detail)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


    }
}