package com.test.main.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.common.R
import com.test.core.adapterDelegate.DelegateAdapter
import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.main.databinding.OfferItemBinding
import com.test.main.presentation.uimodel.Offer

class OfferAdapterDelegate : DelegateAdapter<Offer, OfferAdapterDelegate.BannerViewHolder>(Offer::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = OfferItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Offer,
        viewHolder: BannerViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class BannerViewHolder(private val binding: OfferItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(offer: Offer) {
            Glide.with(binding.image).load(R.drawable.test).into(binding.image)
            binding.cityTxt.text = offer.town
            binding.priceTxt.text = offer.price
            binding.titleTxt.text = offer.title
        }
    }
}