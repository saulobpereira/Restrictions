package com.restrictions.usecases.associateRestriction

import com.restrictions.gateways.RestrictionGateway

class AssociateRestriction(private val restrictionGateway: RestrictionGateway): AssociateRestrictionInputBoundary {
    override fun associate(input: AssociateRestrictionRequestModel): AssociateRestrictionResponseModel {
        return AssociateRestrictionResponseModel(restrictionGateway.addRestrictionToProduct(input.getProductCode(), input.getRestrictionCode()))
    }
}