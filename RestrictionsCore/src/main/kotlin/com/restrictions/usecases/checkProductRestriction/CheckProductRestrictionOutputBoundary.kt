package com.restrictions.usecases.checkProductRestriction

interface CheckProductRestrictionOutputBoundary {
    fun getViewModel(): CheckProductRestrictionViewModel
    fun present(responseModel: CheckProductRestrictionResponseModel)
}