package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionResponseModel(val retorno: Boolean) {
    fun isRestricted(): Boolean {
        return retorno
    }
}