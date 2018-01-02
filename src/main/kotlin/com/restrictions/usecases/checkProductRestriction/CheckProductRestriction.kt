package com.restrictions.usecases.checkProductRestriction

import com.restrictions.gateways.RestrictionGateway

class CheckProductRestriction(private val restrictionGateway: RestrictionGateway) {

    fun check(input: CheckProductRestrictionInputBoundary) : CheckProductRestrictionOutputBoundary{

        val productRestrictions = restrictionGateway.getProductRestrictions(input.getProductCode())
        val restriction = restrictionGateway.getRestriction(input.getRestrictionCode())

        println(productRestrictions)
        println(restriction)
        return CheckProductRestrictionResponseModel(productRestrictions.contains(restriction))
    }
}