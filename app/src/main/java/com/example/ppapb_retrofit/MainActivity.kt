package com.example.ppapb_retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ppapb_retrofit.databinding.ActivityMainBinding
import com.example.ppapb_retrofit.model.Users
import com.example.ppapb_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUser.layoutManager = LinearLayoutManager(this)

        ApiClient.getInstance().getallusers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    // Extract the list of Data objects from the Users response
                    val usersList = response.body()?.data ?: listOf()

                    binding.rvUser.adapter = UserAdapter(usersList) { user ->
                        // Set up intent to pass data to SecondActivity
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("userId", user.id)
                        intent.putExtra("userName", "${user.firstName} ${user.lastName}")
                        intent.putExtra("userEmail", user.email)
                        intent.putExtra("userAvatar", user.avatar)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                // Handle error
                Log.e("MainActivity", "Error fetching data: ${t.message}")
            }
        })
    }
}