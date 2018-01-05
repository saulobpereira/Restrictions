package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionRequestModel(val product: String, val restriction: String) {
    fun getProductCode(): String{
        return product
    }

    fun getRestrictionCode(): String {
        return restriction
    }

    fun isValid():Boolean{
        return product.isNotBlank() && restriction.isNotBlank()
    }
}