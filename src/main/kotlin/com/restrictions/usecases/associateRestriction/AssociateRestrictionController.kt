package com.restrictions.usecases.associateRestriction

import com.restrictions.http.Controller
import com.restrictions.http.Parameters

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