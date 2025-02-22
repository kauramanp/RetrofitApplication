package com.aman.retrofitapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aman.retrofitapplication.databinding.ItemUsersBinding

class UserAdapter(var userArray : ArrayList<UserResponseItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(val itemUserBinding: ItemUsersBinding) : RecyclerView.ViewHolder(itemUserBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = userArray.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemUserBinding.userItem = userArray[position]
    }
}