package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anative.databinding.ActivityLoginBinding
import org.json.JSONObject

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameInput.text.toString()
            val password = binding.passwordInput.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                fetchUser(username, password)
            } else {
                Toast.makeText(this, "Harap isi kedua kolom", Toast.LENGTH_SHORT).show()
            }
            binding.usernameInput.text.clear()
            binding.passwordInput.text.clear()
        }

        binding.registButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

    private fun fetchUser(username: String, password: String) {
        val url = "https://ubaya.xyz/native/160722042/login.php"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)

                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONObject("data") // Ambil data sebagai JSONObject
                    val user = Gson().fromJson(data.toString(), User::class.java) // Parse langsung ke User object
                    Log.d("apiresult", user.toString())

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("user_id",user?.id)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Username atau password salah.hgkjg", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message ?: "Unknown error")
                Toast.makeText(this, "Error fetching members: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf("username" to username, "password" to password)
            }
        }
        queue.add(stringRequest)
    }

}
