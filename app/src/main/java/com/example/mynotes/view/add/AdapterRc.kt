package com.example.mynotes.view.add

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.databinding.ItemBinding
import com.example.mynotes.model.entity.User

class AdapterRc : RecyclerView.Adapter<AdapterRc.MyViewModel>() {

    private var listItem = emptyList<User>()

    class MyViewModel(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User){
            binding.firstName.text = user.firstName
            binding.lastName.text = user.lastName
            binding.age.text = user.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(
            ItemBinding.inflate
                (LayoutInflater.from
                (parent.context)
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }
    override fun getItemCount(): Int = listItem.size
}
