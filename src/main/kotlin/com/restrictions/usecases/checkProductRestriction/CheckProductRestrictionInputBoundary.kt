package com.restrictions.usecases.checkProductRestriction

interface CheckProductRestrictionInputBoundary {
    fun getProductCode() : String
    fun getRestrictionCode() : String
}