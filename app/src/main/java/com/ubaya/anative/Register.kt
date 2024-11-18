package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.anative.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val fname = binding.firstNameInput.text.toString()
            val lname = binding.lastNameInput.text.toString()
            val username = binding.usernameInput.text.toString()
            val pass = binding.passwordInput.text.toString()

            if (fname.isNotEmpty() || lname.isNotEmpty() || username.isNotEmpty() || pass.isNotEmpty()) {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setTitle("Yakin ingin keluar?")
                    .setMessage("Data yang baru saja anda isi akan hilang jika anda keluar.")
                    .setPositiveButton("Ya") { dialog, which ->
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .setNegativeButton("Tidak") { dialog, which ->
                        dialog.dismiss()
                    }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            } else {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }
        }


    }
}
