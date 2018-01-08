package com.restrictions.interfaceAdapters.checkProductRestriction

import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionOutputBoundary
import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionResponseModel
import com.restrictions.usecases.checkProductRestriction.CheckProductRestrictionViewModel

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