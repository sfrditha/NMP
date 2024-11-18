package com.ubaya.anative

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ubaya.anative.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val fragments: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragments.add(WhatWePlayFragment())
        fragments.add(WhoWeAreFragment())
        fragments.add(ScheduleFragment())

        binding.viewPager.adapter = FragAdapter(this, fragments)

        val idFragment = intent.getIntExtra("home_index", 0)

        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemWhatWePlay -> binding.viewPager.currentItem = 0
                R.id.itemWhoWeAre -> binding.viewPager.currentItem = 1
                R.id.itemSchedule -> binding.viewPager.currentItem = 2
                else -> false
            }
            true
        }

        //agar bawahnya bisa berubah
        binding.viewPager.setCurrentItem(idFragment, false)
    }
}
