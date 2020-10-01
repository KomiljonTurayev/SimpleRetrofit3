package com.example.simpleretrofit2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleretrofit2.R
import com.example.simpleretrofit2.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*


class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val d = myList[position]
        holder.itemView.userID_txt.text = d.myUserId.toString()
        holder.itemView.id_txt.text = d.id.toString()
        holder.itemView.title_txt.text = d.title.toString()
        holder.itemView.body_txt.text = d.body.toString()


    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Post>) {
        myList = newList
        notifyDataSetChanged()

    }

}