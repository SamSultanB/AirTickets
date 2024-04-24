package com.test.main.domain.repository

import com.test.main.domain.model.OfferModel

interface OffersRepository {

    suspend fun getOffers(): List<OfferModel>

    fun getLastDestination(): String?

    fun saveDestination(destination: String)

    fun finalDestination(destination: String)

}