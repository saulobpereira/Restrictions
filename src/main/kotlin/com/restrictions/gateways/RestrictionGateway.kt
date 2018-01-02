package com.restrictions.gateways

import com.restrictions.entities.Restriction

interface RestrictionGateway {
    fun getRestriction(code: String) : Restriction
}