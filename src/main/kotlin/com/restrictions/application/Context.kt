package com.restrictions.application

import com.restrictions.gateways.ProductGateway
import com.restrictions.gateways.RestrictionGateway

data class Context(
        var productGateway: ProductGateway,
        var restrictionGateway: RestrictionGateway
        )