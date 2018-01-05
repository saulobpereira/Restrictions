package com.restrictions.usecases.checkProductRestriction

interface CheckProductRestrictionInputBoundary {
    fun check(input: CheckProductRestrictionRequestModel, presenter: CheckProductRestrictionOutputBoundary)
}