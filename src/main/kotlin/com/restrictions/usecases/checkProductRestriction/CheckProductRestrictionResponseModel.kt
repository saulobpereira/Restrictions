package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionResponseModel(val retorno: Boolean) : CheckProductRestrictionOutputBoundary {
    override fun isRestricted(): Boolean {
        return retorno
    }
}