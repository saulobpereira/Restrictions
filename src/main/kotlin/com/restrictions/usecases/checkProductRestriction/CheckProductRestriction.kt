package com.restrictions.usecases.checkProductRestriction

class CheckProductRestriction {

    fun check(input: CheckProductRestrictionInputBoundary) : CheckProductRestrictionOutputBoundary{
        return CheckProductRestrictionResponseModel(true)
    }
}