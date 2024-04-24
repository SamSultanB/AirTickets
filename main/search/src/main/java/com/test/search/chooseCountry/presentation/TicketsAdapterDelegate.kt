package com.test.search.chooseCountry.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.test.common.R
import com.test.core.adapterDelegate.DelegateAdapter
import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.search.chooseCountry.presentation.uimodel.Ticket
import com.test.search.databinding.AirlinesItemBinding

class TicketsAdapterDelegate : DelegateAdapter<Ticket, TicketsAdapterDelegate.TicketViewHolder>(Ticket::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = AirlinesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Ticket,
        viewHolder: TicketViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class TicketViewHolder(private val binding: AirlinesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: Ticket) {
            when(ticket.id){
                2 -> binding.image.setImageResource(R.drawable.flight_2)
                3 -> binding.image.setImageResource(R.drawable.flight_3)
            }
            binding.airlineNameTxt.text = ticket.title
            binding.timeTxt.text = ticket.timeRange
            binding.priceTxt.text = ticket.price
        }
    }
}