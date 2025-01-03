package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import com.ubaya.anative.databinding.ActivityScheduleDetailBinding
import org.json.JSONObject

class ScheduleDetail : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleDetailBinding
    private var scheduleDetail: ArrayList<Schedule> = ArrayList()
    var klik = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityScheduleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val schedule_id = intent.getIntExtra("schedule_index", 0)
        fetchSchedule(schedule_id)

        binding.btnNotifyMe.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            if (klik == 0) {
                klik = 1
                builder.setTitle("Pemberitahuan")
                    .setMessage("Notifikasi berhasil ditambahkan.")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
            } else if (klik == 1) {
                builder.setTitle("Pemberitahuan")
                    .setMessage("Notifikasi sudah ditambahkan sebelumnya.")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
            } else {
                builder.setTitle("Kesalahan")
                    .setMessage("Notifikasi tidak berhasil ditambahkan.")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    private fun fetchSchedule(schedule_id: Int) {
        val url = "https://ubaya.xyz/native/160722042/get_scheduleDetail.php"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)
                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val achievementsType = object : TypeToken<ArrayList<Schedule>>() {}.type
                    scheduleDetail = Gson().fromJson(data.toString(), achievementsType)
                    displaySchedule(scheduleDetail)
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message.toString())
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf("schedule_id" to schedule_id.toString())
            }
        }
        queue.add(stringRequest)
    }

    private fun displaySchedule(schedule: ArrayList<Schedule>) {
        if (schedule.isNotEmpty()) {
            val detail = schedule[0]

            binding.title.text = detail.name
            binding.loc.text = detail.location
            binding.isi.text = detail.description

            if (detail.img_url.isNotEmpty()) {
                val builder = Picasso.Builder(this)
                builder.listener { _, _, exception -> exception.printStackTrace() }
                Picasso.get().load(detail.img_url).into(binding.imageTeam)
            }
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Pemberitahuan")
                .setMessage("Data jadwal tidak ditemukan.")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

}
