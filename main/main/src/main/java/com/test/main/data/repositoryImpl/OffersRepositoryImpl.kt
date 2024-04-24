package com.test.main.data.repositoryImpl

import com.test.main.data.dto.toModel
import com.test.main.data.local.Preferences
import com.test.main.data.remote.OffersApi
import com.test.main.domain.model.OfferModel
import com.test.main.domain.repository.OffersRepository

class OffersRepositoryImpl(private val api: OffersApi, private val preferences: Preferences): OffersRepository {

    override suspend fun getOffers(): List<OfferModel> {
        return api.getOffers().offers.map {
            it.toModel()
        }
    }

    override fun getLastDestination(): String? {
        return preferences.getLastDestination()
    }

    override fun saveDestination(destination: String) {
        preferences.saveNewDestination(destination)
    }

    override fun finalDestination(destination: String) {
        preferences.saveFinalDestination(destination)
    }


}