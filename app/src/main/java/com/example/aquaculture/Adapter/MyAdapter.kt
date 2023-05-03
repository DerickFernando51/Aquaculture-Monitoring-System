package com.example.aquaculture.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aquaculture.Models.User
import com.example.aquaculture.R
import java.util.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

   val userList = ArrayList<User>()

    //var onItemClick : ((User)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
            parent,false
        )
        return MyViewHolder(itemView)








    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.Temperature.text = currentItem.Temperature
        holder.TDS.text = currentItem.TDS
        holder.pH.text = currentItem.pH

        //holder.timestamp.text = currentItem.timestamp

//        holder.itemView.setOnClickListener {
//            onItemClick?.invoke(currentItem)
//
//        }


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(userList : List<User>){
        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()
    }

//    fun deleteItem(position: Int){
//        this.userList.removeAt(position)
//        notifyDataSetChanged()
//    }



    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val Temperature : TextView = itemView.findViewById(R.id.Temperature)
       val TDS : TextView = itemView.findViewById(R.id.TDS)
        val pH : TextView = itemView.findViewById(R.id.pH)
//        val timestamp : TextView = itemView.findViewById(R.id.timestamp)
        //val buttondlt : Button = itemView.findViewById(R.id.deletebtn)








    }


}