package com.restrictions.usecases.associateRestriction

class AssociateRestrictionPresenter: AssociateRestrictionOutputBoundary {
    var model = AssociateRestrictionViewModel()
    override fun getViewModel(): AssociateRestrictionViewModel {
        return model
    }

    override fun present(responseModel: AssociateRestrictionResponseModel) {
        model.success = responseModel.success
    }
}