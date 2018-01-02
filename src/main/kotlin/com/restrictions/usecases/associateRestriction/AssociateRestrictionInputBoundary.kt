package com.restrictions.usecases.associateRestriction

interface AssociateRestrictionInputBoundary {
    fun associate(input: AssociateRestrictionRequestModel): AssociateRestrictionResponseModel
}