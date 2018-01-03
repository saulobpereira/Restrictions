package com.restrictions.usecases.associateRestriction

interface AssociateRestrictionOutputBoundary {
    fun getViewModel(): AssociateRestrictionViewModel
    fun present(responseModel: AssociateRestrictionResponseModel)
}