package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionRequestModel(val product: String, val restriction: String) : CheckProductRestrictionInputBoundary {
    override fun getProductCode(): String{
        return product
    }

    override fun getRestrictionCode(): String {
        return restriction
    }
}