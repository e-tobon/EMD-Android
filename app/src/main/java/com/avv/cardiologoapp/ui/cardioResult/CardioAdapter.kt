package com.avv.cardiologoapp.ui.cardioResult

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.avv.cardiologoapp.data.cardioValue
import com.avv.cardiologoapp.databinding.CardioItemBinding

class CardioAdapter(private val context: Context, private val cardioList: List<cardioValue>): RecyclerView.Adapter<CardioAdapter.ViewHolder>() {

    class ViewHolder(view: CardioItemBinding): RecyclerView.ViewHolder(view.root){
        val tvCardioValu = view.tvCardioValue
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardioItemBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = cardioList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCardioValu.text = cardioList[position].frecuenica.toString()
    }

}