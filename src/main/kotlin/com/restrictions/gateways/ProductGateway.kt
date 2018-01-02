package com.restrictions.gateways

import com.restrictions.entities.Product

interface ProductGateway {
    fun getProduct(code: String) : Product
}