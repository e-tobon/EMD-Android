package com.avv.cardiologoapp.ui.cardioResult

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.avv.cardiologoapp.data.cardioValue
import com.avv.cardiologoapp.databinding.CardioItemBinding

class CardioAdapter(private val context: Context, private val cardioList:cardioValue): RecyclerView.Adapter<CardioAdapter.ViewHolder>() {

    class ViewHolder(view: CardioItemBinding): RecyclerView.ViewHolder(view.root){
        val tvCardioValue = view.tvBPMValue
        val tvIncX = view.tvValueX
        val tvIncY = view.tvValueY
        val tvIncZ = view.tvValueZ
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardioItemBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCardioValue.text = cardioList.IMU.BPM.toString()
        holder.tvIncX.text = cardioList.IMU.InclinacionX.toString()
        holder.tvIncY.text = cardioList.IMU.InclinacionY.toString()
        holder.tvIncZ.text = cardioList.IMU.InclinacionZ.toString()
    }

}