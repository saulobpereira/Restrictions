package com.restrictions.usecases.checkProductRestriction

import com.restrictions.gateways.RestrictionGateway

class CheckProductRestriction(private val restrictionGateway: RestrictionGateway): CheckProductRestrictionInputBoundary {

    override fun check(input: CheckProductRestrictionRequestModel) : CheckProductRestrictionResponseModel{

        val productRestrictions = restrictionGateway.getProductRestrictions(input.getProductCode())
        val restriction = restrictionGateway.getRestriction(input.getRestrictionCode())
        return CheckProductRestrictionResponseModel(productRestrictions.contains(restriction))
    }
}