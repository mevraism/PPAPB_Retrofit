package com.example.ppapb_retrofit

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide



class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("userName")
        val email = intent.getStringExtra("userEmail")
        val avatarUrl = intent.getStringExtra("userAvatar")

        findViewById<TextView>(R.id.user_name).text = name
        findViewById<TextView>(R.id.user_email).text = email
        val imageView = findViewById<ImageView>(R.id.user_img)
        Glide.with(this).load(avatarUrl).into(imageView)
    }
}