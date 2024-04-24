package com.test.search.chooseCountry.presentation.uimodel

import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.search.chooseCountry.domain.model.TicketModel
import java.text.NumberFormat
import java.util.Locale

data class Ticket(
    val id: Int,
    val title: String,
    val timeRange: String,
    val price: String
): DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return title
    }
}

fun TicketModel.toUI(): Ticket{
    return Ticket(
        id,
        title,
        timeRange,
        "${formatPrice(price)} ₽"
    )
}

fun formatPrice(price: Int): String {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return formatter.format(price).replace(",", " ")
}
