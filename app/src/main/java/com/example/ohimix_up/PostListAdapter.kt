package com.example.ohimix_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class PostListAdapter(val itemList: ArrayList<PostListItem>, val fragment: Fragment):
        RecyclerView.Adapter<PostListAdapter.ViewHolder>(){

    // (1) 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)

        return ViewHolder(view)
    }

    // (3) View에 내용 입력
    override fun onBindViewHolder(holder: PostListAdapter.ViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.date.text = itemList[position].date
        holder.post.text = itemList[position].post
    }

    // (2) 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.user_id)
        val date: TextView = itemView.findViewById(R.id.user_id)
        val post: TextView = itemView.findViewById(R.id.post)
    }


}

