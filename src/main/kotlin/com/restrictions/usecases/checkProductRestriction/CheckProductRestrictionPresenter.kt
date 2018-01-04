package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionPresenter: CheckProductRestrictionOutputBoundary {
    var model = CheckProductRestrictionViewModel()
    override fun getViewModel(): CheckProductRestrictionViewModel {
        return model
    }

    override fun present(responseModel: CheckProductRestrictionResponseModel) {
        model.restricted = responseModel.isRestricted()
        model.error = responseModel.error
    }
}