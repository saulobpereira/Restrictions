package com.restrictions.interfaceAdapters.associateRestriction

import com.restrictions.usecases.associateRestriction.AssociateRestrictionOutputBoundary
import com.restrictions.usecases.associateRestriction.AssociateRestrictionResponseModel
import com.restrictions.usecases.associateRestriction.AssociateRestrictionViewModel

class AssociateRestrictionPresenter: AssociateRestrictionOutputBoundary {
    var model = AssociateRestrictionViewModel()
    override fun getViewModel(): AssociateRestrictionViewModel {
        return model
    }

    override fun present(responseModel: AssociateRestrictionResponseModel) {
        model.success = responseModel.success
    }
}