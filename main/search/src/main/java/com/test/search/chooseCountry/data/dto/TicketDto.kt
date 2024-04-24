package com.test.search.chooseCountry.data.dto

import com.test.search.chooseCountry.domain.model.TicketModel

data class TicketDto(
    val id: Int,
    val title: String,
    val time_range: List<String>,
    val price: PriceDto
)

fun TicketDto.toModel(): TicketModel{
    return TicketModel(
        id,
        title,
        time_range.joinToString(" "),
        price.value
    )
}
