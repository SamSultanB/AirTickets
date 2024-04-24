package com.test.search.seeAll.presentation.uimodel

import com.test.core.adapterDelegate.DelegateAdapterItem

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: Int,
    val provider_name: String,
    val company: String,
    val departure: Departure,
    val arrival: Arrival,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,

    val has_luggage: Boolean,
    val priceLuggage: Int,
    val has_hand_luggage: Boolean,
    val size: String?,

    val is_returnable: Boolean,
    val is_exchangable: Boolean
): DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return company
    }
}