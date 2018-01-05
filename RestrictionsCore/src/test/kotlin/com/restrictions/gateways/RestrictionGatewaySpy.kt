package com.restrictions.gateways

import com.restrictions.entities.Restriction

class RestrictionGatewaySpy : RestrictionGateway {
    override fun addRestrictionToProduct(productCode: String, restrictionCode: String): Boolean {
        return true
    }

    override fun getRestriction(code: String): Restriction {
        return Restriction(code)
    }

    override fun getProductRestrictions(productCode: String): List<Restriction> {
        return arrayListOf(Restriction("r1"))
    }
}