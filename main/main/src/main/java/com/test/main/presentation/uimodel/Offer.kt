package com.test.main.presentation.uimodel

import com.test.core.adapterDelegate.DelegateAdapterItem

data class Offer(
    val id: Int,
    val title: String,
    val town: String,
    val image: String,
    val price: String
): DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return title
    }
}
