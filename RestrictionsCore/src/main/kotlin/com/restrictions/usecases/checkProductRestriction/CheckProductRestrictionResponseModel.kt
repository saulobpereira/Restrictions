package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionResponseModel(val retorno: Boolean, val error: Boolean) {
    fun isRestricted(): Boolean {
        return retorno
    }
}