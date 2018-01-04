package com.restrictions.usecases.associateRestriction

import com.restrictions.gateways.RestrictionGateway

class AssociateRestriction(private val restrictionGateway: RestrictionGateway): AssociateRestrictionInputBoundary {
    override fun associate(input: AssociateRestrictionRequestModel, presenter: AssociateRestrictionOutputBoundary) {
        val success = if(input.isValid()) {
            restrictionGateway.addRestrictionToProduct(input.getProductCode(), input.getRestrictionCode())
        }else {
            false
        }
         presenter.present(
                 AssociateRestrictionResponseModel(success)
         )
    }
}
