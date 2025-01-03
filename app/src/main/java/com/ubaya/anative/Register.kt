package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.anative.databinding.ActivityRegisterBinding
import org.json.JSONObject

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val fname = binding.firstNameInput.text.toString().trim()
            val lname = binding.lastNameInput.text.toString().trim()
            val username = binding.usernameInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()
            val repeatPassword = binding.repeatPasswordInput.text.toString().trim()

            if (binding.termsCheckbox.isChecked) {
                // Cek apakah semua input sudah diisi
                if (fname.isEmpty() || lname.isEmpty() || username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                    builder
                        .setTitle("Peringatan")
                        .setMessage("Semua kolom harus diisi.")
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss() // Tutup dialog
                        }
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                    return@setOnClickListener // Hentikan eksekusi
                }

                // Cek apakah password sesuai
                if (password != repeatPassword) {
                    Toast.makeText(this, "Password tidak sesuai.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener // Hentikan eksekusi
                }

                insertUser(fname, lname, username, password)
            } else {
                Toast.makeText(this, "Setujui term & condition untuk melanjutkan", Toast.LENGTH_SHORT).show()
            }
        }

        binding.backButton.setOnClickListener {
            val fname = binding.firstNameInput.text.toString().trim()
            val lname = binding.lastNameInput.text.toString().trim()
            val username = binding.usernameInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()
            val repeatPassword = binding.repeatPasswordInput.text.toString().trim()

            if (fname.isNotEmpty() || lname.isNotEmpty() || username.isNotEmpty() || password.isNotEmpty() || repeatPassword.isNotEmpty()) {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setTitle("Yakin ingin keluar?")
                    .setMessage("Data yang baru saja anda isi akan hilang jika anda keluar.")
                    .setPositiveButton("Ya") { _, _ ->
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .setNegativeButton("Tidak") { dialog, _ ->
                        dialog.dismiss()
                    }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
    }

    private fun insertUser(fname: String, lname: String, username: String, password: String) {
        val url = "https://ubaya.xyz/native/160722042/register.php"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)

                when (obj.getString("result")) {
                    "OK" -> {
                        Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                    }
                    "DOUBLE" -> {
                        Toast.makeText(this, "Username sudah terdaftar.", Toast.LENGTH_SHORT).show()
                        binding.usernameInput.text.clear()
                    }
                    else -> {
                        val message = obj.optString("message", "Gagal mendaftarkan pengguna.")
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message ?: "Unknown error")
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf(
                    "username" to username,
                    "password" to password,
                    "fname" to fname,
                    "lname" to lname
                )
            }
        }
        queue.add(stringRequest)
    }
}
