package com.restrictions.usecases.checkProductRestriction

import com.restrictions.http.Controller
import com.restrictions.http.Parameters

class CheckProductRestrictionController(
        private val useCase: CheckProductRestrictionInputBoundary,
        private val presenter: CheckProductRestrictionOutputBoundary,
        private val view: CheckProductRestrictionView): Controller {

    override fun handle(parameters: Parameters): String{
        useCase.check(
                CheckProductRestrictionRequestModel(
                        parameters.get("productCode"),
                        parameters.get("restrictionCode"))
                , presenter)
        return view.generateView(presenter.getViewModel())
    }
}