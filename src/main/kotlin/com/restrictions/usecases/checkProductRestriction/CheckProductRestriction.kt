package com.restrictions.usecases.checkProductRestriction

import com.restrictions.gateways.RestrictionGateway

class CheckProductRestriction(private val restrictionGateway: RestrictionGateway): CheckProductRestrictionInputBoundary {
    override fun check(input: CheckProductRestrictionRequestModel, presenter: CheckProductRestrictionOutputBoundary) {
        val productRestrictions = restrictionGateway.getProductRestrictions(input.getProductCode())
        val restriction = restrictionGateway.getRestriction(input.getRestrictionCode())
        presenter.present(CheckProductRestrictionResponseModel(productRestrictions.contains(restriction)))
    }
}