package com.test.search.seeAll.data.dto

data class TicketDto(
    val id: Int,
    val badge: String?,
    val price: PriceDto,
    val provider_name: String,
    val company: String,
    val departure: DepartureDto,
    val arrival: ArrivalDto,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val luggage: LuggageDto?,
    val hand_luggage: HandLuggageDto,
    val is_returnable: Boolean,
    val is_exchangable: Boolean
)
