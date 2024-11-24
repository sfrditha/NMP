package com.ubaya.anative

import java.sql.Date

data class User(val id: Int,
                val fname: String,
                val lname: String,
                val username: String,
                val email: String,
                val password: String,
                val bod: String) {
}