package com.restrictions.usecases.associateRestriction

class AssociateRestrictionResponseModel(val success: Boolean) {
    fun isSuccessful(): Boolean {
        return success
    }
}