package com.restrictions.gateways

import com.restrictions.entities.Restriction

interface RestrictionGateway {
    fun getRestriction(code: String) : Restriction
    fun getProductRestrictions(productCode: String): List<Restriction>
    fun addRestrictionToProduct(productCode: String, restrictionCode: String): Boolean
}