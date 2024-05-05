package com.example.exam.ui.theme


import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.squareup.picasso.Picasso


 data class Client(
    val id: Int,

    val name: String,
    val address: String,
    val imageUrl: String,
    val isActive: Boolean

)

class ClientAdapter : ListAdapter<Client, ClientAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.client, parent, false)
        return ProductViewHolder(view)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val client = getItem(position)
        holder.bind(client)
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val clientAdress: TextView = itemView.findViewById(R.id.address)
        private val clientName: TextView = itemView.findViewById(R.id.title)
        private val imageUrl: ImageView=itemView.findViewById(R.id.avatar)

        


        fun bind(product: Client) {
            clientAdress.text = product.address
            clientName.text = product.name
            Picasso.get()
                .load(product.imageUrl)
                .into(imageUrl)






        }

    }

    private class ProductDiffCallback : DiffUtil.ItemCallback<Client>() {
        override fun areItemsTheSame(oldItem: Client, newItem: Client): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Client, newItem: Client): Boolean {
            return oldItem == newItem
        }
    }
}
