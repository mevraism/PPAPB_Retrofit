package com.example.ppapb_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ppapb_retrofit.databinding.ItemUserBinding
import com.example.ppapb_retrofit.model.Data

class UserAdapter(
    private val userList: List<Data>,
    private val onItemClick: (Data) -> Unit
) : RecyclerView.Adapter<UserAdapter.ItemUserViewHolder>() {

    inner class ItemUserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Data) {
            binding.userName.text = "${user.firstName} ${user.lastName}"
            binding.userEmail.text = user.email
            // Load avatar if using an image loading library like Glide or Picasso
            Glide.with(binding.userImg.context).load(user.avatar).into(binding.userImg)

            binding.root.setOnClickListener {
                onItemClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemUserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemUserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size
}
