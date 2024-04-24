package com.test.search.chooseCountry.presentation.uimodel

import com.test.search.chooseCountry.domain.model.DestinationsModel

data class Destinations(
    var start: String,
    var destination: String
)

fun DestinationsModel.toUI(): Destinations{
    return Destinations(
        start,
        destination
    )
}
