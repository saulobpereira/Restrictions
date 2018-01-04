package com.restrictions.usecases.checkProductRestriction

import com.restrictions.gateways.RestrictionGateway

class CheckProductRestriction(private val restrictionGateway: RestrictionGateway): CheckProductRestrictionInputBoundary {
    override fun check(input: CheckProductRestrictionRequestModel, presenter: CheckProductRestrictionOutputBoundary) {
        val valid = input.isValid()
        val ret = if(valid) {
            val productRestrictions = restrictionGateway.getProductRestrictions(input.getProductCode())
            val restriction = restrictionGateway.getRestriction(input.getRestrictionCode())
            productRestrictions.contains(restriction)
        }else{
            false
        }
        presenter.present(CheckProductRestrictionResponseModel(ret, !valid))
    }
}