package com.restrictions.usecases.checkProductRestriction

import com.restrictions.entities.Restriction
import com.restrictions.gateways.RestrictionGateway

class RestrictionGatewayTest: RestrictionGateway {
    override fun getRestriction(code: String): Restriction {
        return Restriction("r1")
    }

    override fun getProductRestrictions(productCode: String): List<Restriction> {
        return arrayListOf(Restriction("r1"))
    }
}