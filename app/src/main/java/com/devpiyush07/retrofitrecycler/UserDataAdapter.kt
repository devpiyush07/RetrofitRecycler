package com.devpiyush07.retrofitrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpiyush07.retrofitrecycler.DataClass.UsersDataItem
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class UserDataAdapter(var context: Context, var userList: List<UsersDataItem>) : RecyclerView.Adapter<UserDataAdapter.UserDataViewHolder>() {

    class UserDataViewHolder(userView: View ) : RecyclerView.ViewHolder(userView) {
        val userName = userView.findViewById<MaterialTextView>(R.id.UserName)
        val userPhoto: ShapeableImageView = userView.findViewById<ShapeableImageView>(R.id.UserPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
       val view = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.users,parent,false)
        return UserDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        Glide
            .with(context)
            .load(userList[position].avatar_url)
            .into(holder.userPhoto)

        holder.userName.text = userList[position].login
    }
}