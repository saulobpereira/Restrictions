package com.restrictions.usecases.checkProductRestriction

class CheckProductRestrictionViewImpl: CheckProductRestrictionView {
    override fun generateView(viewModel: CheckProductRestrictionViewModel): String {
        return viewModel.getMessage()
    }
}