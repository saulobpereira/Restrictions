package com.restrictions.interfaceAdapters.associateRestriction

import com.restrictions.http.Controller
import com.restrictions.http.Parameters
import com.restrictions.usecases.associateRestriction.AssociateRestrictionInputBoundary
import com.restrictions.usecases.associateRestriction.AssociateRestrictionOutputBoundary
import com.restrictions.usecases.associateRestriction.AssociateRestrictionRequestModel

class AssociateRestrictionController(
        private val useCase: AssociateRestrictionInputBoundary,
        private val presenter: AssociateRestrictionOutputBoundary,
        private val view: AssociateRestrictionView): Controller {

    override fun handle(parameters: Parameters): String {
        useCase.associate(
                AssociateRestrictionRequestModel(
                        parameters.get("productCode"),
                        parameters.get("restrictionCode"))
                , presenter)
        return view.generateView(presenter.getViewModel())
    }
}